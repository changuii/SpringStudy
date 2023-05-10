package com.CRUD.crud.post;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final List<PostDto> postlist;

    public PostRestController(){
        this.postlist = new ArrayList<>();
    }

    // http://localhost:8080/post

    // POST /post
    // /post경로에 POST요청이 들어오면 이해를 할 수 있다.
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postlist.add(postDto);
    }

    // GET /post
    // post경로에 GET요청이 들어오면 이해할 수 있다.
    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("in read post all");
        return this.postlist;
    }

    // GET /post/0/  즉, 쿼리를 사용하지 않았다.
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read Post");
        return this.postlist.get(id);
    }


    // PUT /post/0/
    @PutMapping("{id}") // 새로운 데이터가 아닌 보내고 있는 데이터를 해당 위치에 넣어달라는 말, 즉 새로운 데이터는 POST 대체를할 때는 PUT
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
        PostDto targetPost = this.postlist.get(id);
        if(postDto.getTitle() != null){
            targetPost.setTitle(postDto.getTitle());
        }
        if(postDto.getContent() != null){
            targetPost.setContent(postDto.getContent());
        }
        this.postlist.set(id, targetPost);
    }

    // DELETE /post/0/
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id){
        this.postlist.remove(id);
    }

}
