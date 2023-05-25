package dev.changui.jpa;

import dev.changui.jpa.entity.PostEntity;
import dev.changui.jpa.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;

    public PostDao(
            @Autowired PostRepository postRepository
            ){
        this.postRepository = postRepository;
    }

    public void createPost(PostDto postDto){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        postEntity.setWriter(postDto.getWriter());
        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int id){
        Optional<PostEntity> postEntity = this.postRepository.findById((long) id);
        if(postEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();

    }

    public Iterator<PostEntity> readPostAll(){
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int id, PostDto postDto){
        Optional<PostEntity> targetEntity = this.postRepository.findById(Long.valueOf(id));
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(
                postDto.getTitle() == null ? postEntity.getTitle() : postDto.getTitle());
        postEntity.setContent(
                postDto.getContent() == null ? postEntity.getContent() : postDto.getContent());
        this.postRepository.save(postEntity);
    }

    public void deletePost(int id){
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }


}
