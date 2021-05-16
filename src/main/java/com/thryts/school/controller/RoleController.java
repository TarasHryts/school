package com.thryts.school.controller;

import com.thryts.school.dto.RoleDto;
import com.thryts.school.dto.util.RoleDtoUtil;
import com.thryts.school.entity.Role;
import com.thryts.school.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/load_roles")
    public void load(@RequestParam String fileName) {
        roleService.loadRoles(fileName);
    }

    @PostMapping("/add")
    public void add(@RequestBody RoleDto roleDto) {
        roleService.create(RoleDtoUtil.createRoleFromDto(roleDto));
    }

    @DeleteMapping("/{roleId}")
    public void delete(@PathVariable("roleId") Long roleId) {
        roleService.delete(roleService.getById(roleId).get());
    }

    @GetMapping("/all")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}
