package com.blogapi.blogapi.controllers;


import com.blogapi.blogapi.services.UserService;
import com.blogapi.blogapi.utility.JWTUtility;
import com.blogapi.blogapi.models.JwtRequest;
import com.blogapi.blogapi.models.JwtResponse;
import com.blogapi.blogapi.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/home")
    public String home(){
        return "home page";
    }
    
  /*   @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userServ.getUsers();
    } */

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest)throws Exception{
        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                   jwtRequest.getUsername(),
                   jwtRequest.getPassword()
                )
            );
        }catch (BadCredentialsException e){
            throw new Exception("INVALID",e);
        }
        final UserDetails userDetails
        =userServ.loadUserByUsername(jwtRequest.getUsername());

        final String token =
        jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }

    @PostMapping()
    public UserModel storeUser(@RequestBody UserModel user){
        return this.userServ.saveUser(user);
    }
}
