package com.example.database.dao;

import com.example.database.entity.PostEntity;

import java.util.List;

public interface DAO {
    public void createPost(PostEntity postEntity);
    public PostEntity readPost(long id);
    public List<PostEntity> readAllPost();
    public void updatePost(PostEntity postEntity);
    public void removePost(long id);

}
