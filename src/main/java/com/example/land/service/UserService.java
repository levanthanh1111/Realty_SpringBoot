package com.example.land.service;

import com.example.land.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUser(Long id);
    User createUser(User user);
    User updateUser(User user, Long id);
    Boolean deleteUser(Long id);
}
