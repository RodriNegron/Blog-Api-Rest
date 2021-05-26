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
        return (ArrayList<PostModel>) postRepository.findAllByOrderByCreatedAtDesc();
    }
    public ArrayList <PostModel> findByTitle(String title){
        return (ArrayList<PostModel>) postRepository.findByTitleLike(title);
    }

    public PostModel savePost(PostModel post){
        return postRepository.save(post);
    }

    public PostModel findById(Integer id){
        return postRepository.findById(id).get();
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
