package com.thryts.school.dto.util;

import com.thryts.school.dto.RoleDto;
import com.thryts.school.entity.Role;

public class RoleDtoUtil {
    public static Role createRoleFromDto(RoleDto roleDto) {
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());
        return role;
    }
}
