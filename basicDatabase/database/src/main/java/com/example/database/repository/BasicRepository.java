package com.example.database.repository;


import com.example.database.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BasicRepository {
    public void save(PostEntity postEntity);
    public PostEntity getById(long id);
    public List<PostEntity> getAll();
    public void update(long id, PostEntity postEntity);
    public void remove(long id);

}
