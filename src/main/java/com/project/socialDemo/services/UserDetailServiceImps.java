package com.project.socialDemo.services;

import com.project.socialDemo.entities.User;
import com.project.socialDemo.repos.UserRepository;
import com.project.socialDemo.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImps implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user != null) {
            return JwtUserDetails.create(user);
        }
        return null;
    }
}
