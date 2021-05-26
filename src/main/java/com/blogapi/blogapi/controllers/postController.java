package com.blogapi.blogapi.controllers;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.blogapi.blogapi.models.PostModel;
import com.blogapi.blogapi.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class postController {

    @Autowired
    private PostService postServ;

    @GetMapping()
    public ArrayList<PostModel> getPosts(){
        return postServ.getPost();
    }

    @GetMapping( path = "/{id}")
    public ResponseEntity<PostModel> findById(@PathVariable("id")Integer id){
        try {
            PostModel post = postServ.findById(id);
            return new ResponseEntity<PostModel>(post, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<PostModel>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public PostModel storePost(@RequestBody PostModel post){
        return this.postServ.savePost(post);
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id) {
        try {
            PostModel existPost = postServ.findById(id);
            existPost.setActive(false);;            
            postServ.savePost(existPost);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
