package com.blogapi.blogapi.repositories;

import com.blogapi.blogapi.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Integer> {
    UserModel findByEmail(String email);
}
