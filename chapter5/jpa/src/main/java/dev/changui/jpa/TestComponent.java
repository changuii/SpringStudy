package dev.changui.jpa;


import dev.changui.jpa.entity.BoardEntity;
import dev.changui.jpa.entity.PostEntity;
import dev.changui.jpa.repository.BoardRepository;
import dev.changui.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    public TestComponent(
            @Autowired BoardRepository boardRepository,
            @Autowired PostRepository postRepository
            ){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("New board");
        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
        System.out.println(newBoardEntity);

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("hello ORM");
        postEntity.setContent("This Entity is created by hibernate!");
        postEntity.setWriter("changui");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);
        System.out.println(newPostEntity);

        System.out.println(postRepository.findAllByWriter("changui").size());


    }

}
