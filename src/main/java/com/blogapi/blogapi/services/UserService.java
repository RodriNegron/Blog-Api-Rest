package com.blogapi.blogapi.services;

import java.util.ArrayList;
import java.util.Optional;

import com.blogapi.blogapi.models.UserModel;
import com.blogapi.blogapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    public ArrayList <UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> findById(Integer id){
        return userRepository.findById(id);
    }

   /*   public ArrayList<UserModel> findByEmail(String email){
        return userRepository.findByEmail(email);
    }  */

    public boolean deleteUser(Integer id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception error){
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       /*  UserModel user= userRepository.findByEmail(email); */
        return new User("admin","password",new ArrayList<>());
    }
}
