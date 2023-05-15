package dev.changui.misson2.repository;

import dev.changui.misson2.model.PostDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface PostRepository {
    PostDto createPost(PostDto dto);
    PostDto readPost(Long id);
    Collection<PostDto> readPostAll();
    boolean updatePost(Long id, PostDto dto);
    boolean deletePost(Long id);




}
