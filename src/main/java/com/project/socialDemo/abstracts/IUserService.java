package com.project.socialDemo.abstracts;

import com.project.socialDemo.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    User findById(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
