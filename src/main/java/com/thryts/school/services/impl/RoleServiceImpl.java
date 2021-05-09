package com.thryts.school.services.impl;

import com.thryts.school.entity.Role;
import com.thryts.school.repository.RoleRepository;
import com.thryts.school.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> loadRoles(String fileName) {
        BufferedReader reader = null;
        List<Role> roleList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Role role = new Role(splitLine[0]);
                roleRepository.save(role);
                roleList.add(role);
            }
            return roleList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return roleList;
    }

    @Transactional
    @Override
    public Optional<Role> create(Role role) {
        return Optional.ofNullable(roleRepository.save(role));
    }

    @Override
    public Optional<Role> getById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    @Transactional
    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
