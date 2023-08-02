package com.example.database.controller;


import com.example.database.dao.DAOImpl;
import com.example.database.dto.PostDto;
import com.example.database.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Controller {

    private final PostService postService;

    public Controller(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }



    @PostMapping
    public void create(
            @RequestBody PostDto postDto
    ){
        postService.createPost(postDto);
    }

    @GetMapping("/{id}")
    public PostDto read(@PathVariable("id") long id){
        return this.postService.readPost(id);
    }

    @GetMapping
    public List<PostDto> readAll(){
        return this.postService.readALlPost();
    }

    @PutMapping
    public void update(
            @RequestBody PostDto postDto
    ){
        this.postService.updatePost(postDto);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") long id
    ){
        this.postService.removePost(id);
    }

}
