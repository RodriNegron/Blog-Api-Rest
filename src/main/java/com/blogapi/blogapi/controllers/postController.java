package com.blogapi.blogapi.controllers;

import java.util.ArrayList;

import com.blogapi.blogapi.models.PostModel;
import com.blogapi.blogapi.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @PostMapping
    public PostModel storePost(@RequestBody PostModel post){
        return this.postServ.savePost(post);
    }

    
}
