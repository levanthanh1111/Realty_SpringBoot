package com.example.land.service;

import com.example.land.entity.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getRole(Long id);
    Role createRole(Role role);
    Role updateRole(Role role, Long id);
    Boolean deleteRole(Long id);
}
