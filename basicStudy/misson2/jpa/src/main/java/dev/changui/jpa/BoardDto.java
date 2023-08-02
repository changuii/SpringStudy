package dev.changui.jpa;

import java.util.List;

public class BoardDto {
    private int id;
    private String name;
    private List<PostDto> PostList;

    public BoardDto(){}

    public BoardDto(int id, String name, List<PostDto> postList) {
        this.id = id;
        this.name = name;
        PostList = postList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostDto> getPostList() {
        return PostList;
    }

    public void setPostList(List<PostDto> postList) {
        PostList = postList;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PostList=" + PostList +
                '}';
    }
}
