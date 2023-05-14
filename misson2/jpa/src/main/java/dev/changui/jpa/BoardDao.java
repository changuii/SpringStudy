package dev.changui.jpa;


import dev.changui.jpa.entity.BoardEntity;
import dev.changui.jpa.entity.PostEntity;
import dev.changui.jpa.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class BoardDao {
    private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);

    private final BoardRepository boardRepository;

    public BoardDao(
            @Autowired BoardRepository boardRepository
    ){
        this.boardRepository = boardRepository;
    }

    public void createBoard(BoardDto boardDto){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(boardDto.getName());
        boardEntity.setPostEntityList(new ArrayList<>());
        boardRepository.save(boardEntity);
    }

    public BoardEntity readBoard(int id){
        Optional<BoardEntity> targetBoard = boardRepository.findById((long) id);
        if(targetBoard.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return targetBoard.get();
    }

    public Iterator<BoardEntity> readBoardAll(){
       return boardRepository.findAll().iterator();
    }

    public void updateBoard(int id, BoardDto boardDto){
        Optional<BoardEntity> target = boardRepository.findById((long) id);
        BoardEntity targetBoard = target.get();
        targetBoard.setName(boardDto.getName() == null ? targetBoard.getName() : boardDto.getName());
        if(boardDto.getPostList() != null){
            Iterator<PostDto> list = boardDto.getPostList().iterator();
            List<PostEntity> targetList = targetBoard.getPostEntityList();
            while(list.hasNext()){
                PostEntity postEntity = new PostEntity();
                PostDto postDto = list.next();
                postEntity.setTitle(postDto.getTitle());
                postEntity.setContent(postDto.getContent());
                postEntity.setWriter(postDto.getWriter());
                postEntity.setBoardEntity(null);
                targetList.add(postEntity);
            }
            targetBoard.setPostEntityList(targetList);
        }
        else{
            targetBoard.setPostEntityList(targetBoard.getPostEntityList());
        }
        boardRepository.save(targetBoard);
    }

    public void deleteBoard(int id){
        Optional<BoardEntity> target = boardRepository.findById((long) id);
        if(target.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        boardRepository.delete(target.get());
    }


}
