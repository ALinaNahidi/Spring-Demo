package com.springdemo.storylab.security;

import com.springdemo.storylab.controller.StoryController;
import com.springdemo.storylab.service.CommentsService;
import com.springdemo.storylab.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(StoryController.class)
class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoryService storyService;

    @MockBean
    private CommentsService commentsService;



}


