package dev.changui.misson2.repository;

import dev.changui.misson2.model.PostDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public class inMemoryPostRepository implements PostRepository{


    @Override
    public PostDto createPost(PostDto dto) {
        return null;
    }

    @Override
    public PostDto readPost(Long id) {
        return null;
    }

    @Override
    public Collection<PostDto> readPostAll() {
        return null;
    }

    @Override
    public boolean updatePost(Long id, PostDto dto) {
        return false;
    }

    @Override
    public boolean deletePost(Long id) {
        return false;
    }
}
