package dev.changui.misson2.repository;

import dev.changui.misson2.model.PostDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface PostRepository {
    PostDto createPost(Long boardId, PostDto dto);
    PostDto readPost(Long boardId, Long postId);
    Collection<PostDto> readPostAll(Long boardId);
    boolean updatePost(Long boardId, Long postId, PostDto dto);
    boolean deletePost(Long boardId, Long postId, String password);




}
