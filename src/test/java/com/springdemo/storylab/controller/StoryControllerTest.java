package com.springdemo.storylab.controller;

import com.springdemo.storylab.service.CommentsService;
import com.springdemo.storylab.service.StoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoryService storyService;

    @MockBean
    private CommentsService commentsService;



    @WithMockUser(value = "author12")
    @Test
    void storyListUnauthorized() throws Exception{

        this.mockMvc
                .perform(get("/storyLab/list-stories"))
                .andExpect(status().isNotFound());
    }



    @WithMockUser(value = "author1")
    @Test
    void storyListAuthorized() throws Exception{

        assertThat(storyService.findAll()).isNotNull();

    }



}