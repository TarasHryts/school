package com.thryts.school.services;

import com.thryts.school.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> create(Role role);

    Optional<Role> getById(Long roleId);

    void delete(Role role);

    List<Role> getAllRoles();
}
