package dev.changui.jpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    void readPost() throws Exception {
        // given 어떤 데이터가 준비가 되어있다. 조건
        // PostEntity가 존재할 때 (PostService가 PostEntity를 잘 돌려줄때)
        final int id = 10;
        PostDto testDto = new PostDto();
        testDto.setId(id);
        testDto.setTitle("Unit Title");
        testDto.setContent("Unit Content");
        testDto.setWriter("unit");

        given(postService.readPost(id)).willReturn(testDto);
        // when  어떤 행위가 일어났을때 (함수 호출 등) 실행
        // 경로에 GET 요청이 오면
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
                .andDo(print());

        // then  어떤 결과가 올 것인지, 이렇게 될 것이다.
        // PostDto가 응답된다. 반환된다.
        actions.andExpectAll(
          status().isOk(),
          content().contentType(MediaType.APPLICATION_JSON),
          jsonPath("$.title", is("Unit Title")),
            jsonPath("$.content", is("Unit Content")),
            jsonPath("$.writer", is("unit"))
        );

    }

    @Test
    void readPostAll() throws Exception {
        //given
        PostDto post1 = new PostDto();
        post1.setTitle("title 1");
        post1.setContent("test");
        post1.setWriter("test");

        PostDto post2 = new PostDto();
        post2.setTitle("title 2");
        post2.setContent("test2");
        post2.setWriter("test2");

        List<PostDto> readAllPost = Arrays.asList(post1, post2);
        given(postService.readPostAll()).willReturn(readAllPost);


        //when
        final ResultActions actions = mockMvc.perform(get("/post"))
                .andDo(print());

        //then
        actions.andExpectAll(
          status().isOk(),
          content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
          jsonPath("$", hasSize(readAllPost.size()))
        );


    }
}