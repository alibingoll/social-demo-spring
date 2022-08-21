package com.project.socialDemo.controllers;

import com.project.socialDemo.abstracts.IUserService;
import com.project.socialDemo.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        User newUser = this.userService.createUser(user);
        return newUser;
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
         return this.userService.findById(userId);
    }

    @PutMapping
    public User updateOneUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
    }
}
