package com.blogapi.blogapi.repositories;

import com.blogapi.blogapi.models.PostModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository <PostModel, Integer>{
    
}
