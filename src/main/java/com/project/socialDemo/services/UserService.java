package com.project.socialDemo.services;

import com.project.socialDemo.abstracts.IUserService;
import com.project.socialDemo.entities.User;
import com.project.socialDemo.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = findById(user.getId());
        System.out.println(user);
        System.out.println(updatedUser);
        if (updatedUser != null) {
            updatedUser = this.userRepository.save(user);
            return updatedUser;
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
