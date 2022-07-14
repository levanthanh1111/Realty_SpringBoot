package com.example.land.service.Impl;

import com.example.land.entity.Role;
import com.example.land.repository.RoleRepository;
import com.example.land.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(Long id) {
        return roleRepository.getById(id);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role, Long id) {
        Role r = roleRepository.getById(id);

        r.setName(role.getName());
        return roleRepository.save(r);
    }

    @Override
    public Boolean deleteRole(Long id) {
        roleRepository.deleteById(id);
        return true;
    }
}
