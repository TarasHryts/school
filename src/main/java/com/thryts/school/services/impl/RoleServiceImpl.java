package com.thryts.school.services.impl;

import com.thryts.school.entity.Role;
import com.thryts.school.repository.RoleRepository;
import com.thryts.school.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
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
