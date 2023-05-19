package dev.changui.jpa;


import dev.changui.jpa.aspect.LogExecutionTime;
import dev.changui.jpa.aspect.LogArguments;
import dev.changui.jpa.aspect.LogReturn;
import dev.changui.jpa.exception.BaseException;
import dev.changui.jpa.exception.PostNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ){
        this.postService = postService;

    }

    @LogArguments
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody PostDto dto){
        logger.info("start processing");
        this.postService.createPost(dto);
        logger.info("finish processing");
    }


    @LogReturn
    @GetMapping("{id}")
    public PostDto readPost( @PathVariable("id") int id){
       return this.postService.readPost(id);
    }



    @LogExecutionTime
    @GetMapping("")
    public List<PostDto> readPostAll(){
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto dto
    ){
        this.postService.updatePost(id, dto);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteMapping(
            @PathVariable("id") int id
    )    {
        this.postService.deletePost(id);

    }


    @PostMapping("test-valid")
    public void testValid(@Valid @RequestBody ValidTestDto validTestDto){
        logger.warn(validTestDto.toString());
    }

    @GetMapping("test-exception")
    public void throwException(){
        throw new PostNotExistException();
    }

}
