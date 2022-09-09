package com.project.socialDemo.controllers;

import com.project.socialDemo.abstracts.IUserService;
import com.project.socialDemo.entities.User;
import com.project.socialDemo.requests.UserRequest;
import com.project.socialDemo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private IUserService userService;

     @PostMapping("/login")
    public String login (@RequestBody UserRequest loginRequest){
         UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword());
         Authentication auth = authenticationManager.authenticate(authToken);
         SecurityContextHolder.getContext().setAuthentication(auth);
         String jwtToken = jwtTokenProvider.generateJwtToken(auth);
         return "Bearer "+jwtToken;
     }

     @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody UserRequest registerRequest){
         if(userService.getOneUserByUserName(registerRequest.getUserName()) != null){
             return new ResponseEntity<>("Username already in use.", HttpStatus.BAD_REQUEST);
         }
         User user = new User();
         user.setUserName(registerRequest.getUserName());
         user.setPassword(registerRequest.getPassword());
         userService.createUser(user);
         return new ResponseEntity<>("User Successfully registered.", HttpStatus.CREATED);
     }
}
