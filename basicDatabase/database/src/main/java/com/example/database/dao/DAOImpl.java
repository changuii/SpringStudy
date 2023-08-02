package com.example.database.dao;


import com.example.database.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

    private final JdbcTemplate jdbcTemplate;
    private final BasicRepository basicRepository;

    public DAO(
            @Autowired JdbcTemplate jdbcTemplate
            @Autowired BasicRepository basicRepository
    ){
        this.jdbcTemplate = jdbcTemplate;
        this.basicRepository = basicRepository;
    }

    public void createTable(){
        jdbcTemplate.execute("CREATE TABLE POST(id INT NOT NULL PRIMARY KEY, title VARCHAR(10) )");
    }

    public void createPost(
            int id,
            String title
    ){
        jdbcTemplate.update("INSERT INTO POST VALUES (?, ?)", id, title);
    }

}
