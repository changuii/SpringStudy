package com.example.database.dao;


import com.example.database.entity.PostEntity;
import com.example.database.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOImpl implements DAO{

    private final JdbcTemplate jdbcTemplate;
    private final BasicRepository basicRepository;

    public DAOImpl(
            @Autowired JdbcTemplate jdbcTemplate,
            @Autowired BasicRepository basicRepository
    ){
        this.jdbcTemplate = jdbcTemplate;
        this.basicRepository = basicRepository;
    }

    public void createTable(){
        jdbcTemplate.execute("CREATE TABLE POST(id INT NOT NULL PRIMARY KEY, title VARCHAR(10) )");
    }


    @Override
    public void createPost(PostEntity postEntity) {
        this.basicRepository.save(postEntity);
    }

    @Override
    public PostEntity readPost(long id) {
        return this.basicRepository.getById(id);
    }

    @Override
    public List<PostEntity> readAllPost() {
        return this.basicRepository.getAll();
    }

    @Override
    public void updatePost(PostEntity postEntity) {
        this.basicRepository.update(postEntity.getId(), postEntity);
    }

    @Override
    public void removePost(long id) {
        this.basicRepository.remove(id);

    }
}
