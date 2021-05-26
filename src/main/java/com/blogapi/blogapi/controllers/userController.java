package com.blogapi.blogapi.controllers;


import com.blogapi.blogapi.services.UserService;
import com.blogapi.blogapi.utility.JWTUtility;

import java.util.Optional;

import com.blogapi.blogapi.models.JwtRequest;
import com.blogapi.blogapi.models.JwtResponse;
import com.blogapi.blogapi.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class userController {

    @Autowired
    private JWTUtility jwtUtility;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userServ;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping( path = "/user/{id}")
    public Optional<UserModel> findById(@PathVariable("id")Integer id){
        return this.userServ.findById(id);
    }
    
    @PostMapping("/user")
    public UserModel storeUser(@RequestBody UserModel user){
        String encryptedPw = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPw);
        return this.userServ.saveUser(user);
    }

    @PostMapping("/auth/login")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest)throws Exception{
        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                   jwtRequest.getEmail(),
                   jwtRequest.getPassword()
                )
            );
        }catch (BadCredentialsException e){
            throw new Exception("INVALID",e);
        }
        final UserDetails userDetails
        =userServ.loadUserByUsername(jwtRequest.getEmail());

        final String token =
        jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }

}
