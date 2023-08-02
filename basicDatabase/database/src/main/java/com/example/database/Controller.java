package com.example.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class Controller {

    final DAO dao;

    public Controller(
            @Autowired DAO dao
    ){
        this.dao = dao;
    }


    @PutMapping("/create")
    public void createTable(){
        dao.createTable();

    }


    @PostMapping
    public void create(
            @RequestParam int id,
            @RequestParam String title
    ){
        dao.createPost(id, title);

    }

}
