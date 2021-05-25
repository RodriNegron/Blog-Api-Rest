package com.blogapi.blogapi.services;

import java.util.*;

import com.blogapi.blogapi.models.PostModel;
import com.blogapi.blogapi.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public ArrayList <PostModel> getPost(){
        return (ArrayList<PostModel>) postRepository.findAll();
    }

    public PostModel savePost(PostModel post){
        return postRepository.save(post);
    }

    public Optional<PostModel> findById(Integer id){
        return postRepository.findById(id);
    }

    public boolean deletePost(Integer id){
        try{
            postRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    
}
