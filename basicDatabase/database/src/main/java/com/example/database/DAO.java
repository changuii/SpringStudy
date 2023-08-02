package com.example.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

    private final JdbcTemplate jdbcTemplate;

    public DAO(
            @Autowired JdbcTemplate jdbcTemplate
    ){
        this.jdbcTemplate = jdbcTemplate;
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
