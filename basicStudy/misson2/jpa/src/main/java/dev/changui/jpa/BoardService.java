package dev.changui.jpa;


import dev.changui.jpa.entity.BoardEntity;
import dev.changui.jpa.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
    private final BoardDao boardDao;

    public BoardService(
            @Autowired BoardDao boardDao
    ){
        this.boardDao = boardDao;
    }

    public void createBoard(BoardDto boardDto){
        boardDao.createBoard(boardDto);
    }
    public BoardDto readBoard(int id){
        BoardEntity target = this.boardDao.readBoard(id);
        Iterator<PostEntity> targetBoardList = target.getPostEntityList().iterator();
        List<PostDto> list = new ArrayList<>();
        while(targetBoardList.hasNext()){
            PostDto postDto = new PostDto();
            PostEntity postEntity = targetBoardList.next();
            postDto.setId(Math.toIntExact(postEntity.getId()));
            postDto.setTitle(postEntity.getTitle());
            postDto.setContent(postEntity.getContent());
            postDto.setWriter(postEntity.getWriter());
            postDto.setBoardId(Math.toIntExact(postEntity.getBoardEntity().getId()));
        }
        return new BoardDto(
                Math.toIntExact(target.getId()),
                target.getName(),
                list
        );
    }
    public List<BoardDto> readBoardAll(){
        Iterator<BoardEntity> targetList = this.boardDao.readBoardAll();
        List<BoardDto> list = new ArrayList<>();
        while(targetList.hasNext()){
            BoardEntity targetBoard = targetList.next();
            BoardDto boardDto = new BoardDto();
            boardDto.setId(Math.toIntExact(targetBoard.getId()));
            boardDto.setName(targetBoard.getName());
            Iterator<PostEntity> targetBoardList = targetBoard.getPostEntityList().iterator();
            List<PostDto> newList = new ArrayList<>();
            while(targetBoardList.hasNext()){
                PostDto postDto = new PostDto();
                PostEntity postEntity = targetBoardList.next();
                postDto.setId(Math.toIntExact(postEntity.getId()));
                postDto.setTitle(postEntity.getTitle());
                postDto.setContent(postEntity.getContent());
                postDto.setWriter(postEntity.getWriter());
                postDto.setBoardId(Math.toIntExact(postEntity.getBoardEntity().getId()));
            }
            boardDto.setPostList(newList);
            list.add(boardDto);
        }
        return list;
    }
    public void updateBoard(int id, BoardDto boardDto){
        this.boardDao.updateBoard(id, boardDto);
    }
    public void deleteBoard(int id){
        this.boardDao.deleteBoard(id);
    }



}
