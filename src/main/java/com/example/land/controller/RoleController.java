package com.example.land.controller;

import com.example.land.entity.Role;
import com.example.land.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("")
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable("id") Long id){
        return roleService.getRole(id);
    }

    @PostMapping("/create")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @PutMapping("/update/{id}")
    public Role updateRole(@RequestBody Role role,@PathVariable("id") Long id){
        return roleService.updateRole(role,id);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteRole(@PathVariable("id") Long id){
        return roleService.deleteRole(id);
    }
}
