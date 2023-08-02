package com.example.database.service;


import com.example.database.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public void createPost(PostDto postDto);
    public PostDto readPost(long id);
    public List<PostDto> readALlPost();
    public void updatePost(PostDto postDto);
    public void removePost(long id);


}
