package com.blogapi.blogapi.repositories;

import com.blogapi.blogapi.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <UserModel, Integer> {
    UserModel findByEmail(String email);
}
