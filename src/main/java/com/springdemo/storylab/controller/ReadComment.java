package com.springdemo.storylab.controller;

import com.springdemo.storylab.entity.Comments;
import com.springdemo.storylab.entity.Story;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public @Data class ReadComment {

    private Story storyObject;
    private Comments commentsObject;

    public ReadComment(Story storyObject, Comments commentsObject) {
        this.storyObject = storyObject;
        this.commentsObject = commentsObject;
    }

    public ReadComment(){

    }
}
