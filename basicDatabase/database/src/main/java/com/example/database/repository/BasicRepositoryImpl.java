package com.example.database.repository;


import com.example.database.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BasicRepositoryImpl implements BasicRepository{

    final JdbcTemplate jdbcTemplate;

    public BasicRepositoryImpl(
            @Autowired JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(PostEntity postEntity) {
        jdbcTemplate.update("INSERT INTO POST VALUES (?, ?)", postEntity.getId(), postEntity.getTitle());
    }

    @Override
    public PostEntity getById(long id) {
        String title =  jdbcTemplate.queryForObject("SELECT title FROM POST WHERE id = ?", String.class,id);
        PostEntity postEntity = new PostEntity(id, title);
        return postEntity;
    }

    @Override
    public List<PostEntity> getAll() {
        List<PostEntity> listEntity = this.jdbcTemplate.query("SELECT * FROM POST",
                (resultSet, rowNum) -> {
            PostEntity postEntity = new PostEntity();
            postEntity.setId(resultSet.getLong("id"));
            postEntity.setTitle(resultSet.getString("title"));
            return postEntity;
                });
        return listEntity;
    }

    @Override
    public void update(long id, PostEntity postEntity) {
        this.jdbcTemplate.update("UPDATE POST SET title = ? WHERE id = ?", postEntity.getTitle(), id);
    }

    @Override
    public void remove(long id) {
        this.jdbcTemplate.update("DELETE FROM POST WHERE id = ?", id);
    }

}
