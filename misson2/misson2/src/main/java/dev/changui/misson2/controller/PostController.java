package dev.changui.misson2.controller;


import dev.changui.misson2.model.PostDto;
import dev.changui.misson2.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping()
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void createPost(PostDto dto){
        this.postRepository.createPost(dto);
    }

    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("id") Long id
    ){
        return this.postRepository.readPost(id);

    }

    @GetMapping("")
    public Collection<PostDto> readPostAll(){
        return this.postRepository.readPostAll();
    }

    @PutMapping("{id}")
    public void updatePost(
            @PathVariable Long id,
            @RequestBody PostDto dto){
        this.postRepository.updatePost(id, dto);
    }

    @DeleteMapping("{id}")
    public void deletePost(
            @PathVariable Long id){
        this.postRepository.deletePost(id);

    }


}
