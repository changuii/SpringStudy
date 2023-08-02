package com.example.database.service;


import com.example.database.dao.DAO;
import com.example.database.dao.DAOImpl;
import com.example.database.dto.PostDto;
import com.example.database.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final DAO dao;
    public PostServiceImpl(
            @Autowired DAO dao
    ){
        this.dao = dao;
    }

    @Override
    public void createPost(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setTitle(postDto.getTitle());
        this.dao.createPost(postEntity);
    }

    @Override
    public PostDto readPost(long id) {
        PostEntity postEntity = this.dao.readPost(id);
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setTitle(postEntity.getTitle());
        return postDto;
    }

    @Override
    public List<PostDto> readALlPost() {
        List<PostEntity> ListEntity = this.dao.readAllPost();
        List<PostDto> listDto = new ArrayList<>();

        for(PostEntity postEntity :ListEntity ){
            PostDto postDto = new PostDto();
            postDto.setId(postEntity.getId());
            postDto.setTitle(postEntity.getTitle());

            listDto.add(postDto);
        }


        return listDto;
    }

    @Override
    public void updatePost(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setTitle(postDto.getTitle());
        this.dao.updatePost(postEntity);
    }

    @Override
    public void removePost(long id) {
        this.dao.removePost(id);
    }
}
