package dev.changui.mybatis;


import dev.changui.mybatis.dao.BoardDao;
import dev.changui.mybatis.dao.PostDao;
import dev.changui.mybatis.dto.BoardDto;
import dev.changui.mybatis.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestComponent {
    private final PostDao postDao;
    private final BoardDao boardDao;

    public TestComponent(
            @Autowired PostDao postDao,
            @Autowired BoardDao boardDao
    ){
        this.boardDao = boardDao;

        BoardDto boardDto = new BoardDto();
        boardDto.setName("new Board");
        this.boardDao.createBoard(boardDto);
        System.out.println(boardDto.getId());



        this.postDao = postDao;
        PostDto newPost = new PostDto();
        newPost.setTitle("From Mybatis");
        newPost.setContent("use Database with Spring boot! ");
        newPost.setWriter("changui");
        newPost.setBoard(1);
        this.postDao.createPost(newPost);


        List<PostDto> postDtoList = this.postDao.readPostAll();
        System.out.println(postDtoList.get(postDtoList.size()-1));

        PostDto firstPost = postDtoList.get(0);
        firstPost.setContent("Content update from mybatis!");
        postDao.updatePost(firstPost);

        System.out.println(this.postDao.readPost(firstPost.getId()));


    }


}
