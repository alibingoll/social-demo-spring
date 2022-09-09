package com.project.socialDemo.abstracts;

import com.project.socialDemo.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getOneUserById(Long id);
    User getOneUserByUserName(String userName);
    User createUser(User user);
    User updateOneUser(User user);
    void deleteOneUserById(Long id);

}
