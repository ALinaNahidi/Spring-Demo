package com.springdemo.storylab.service;

import com.springdemo.storylab.entity.Comments;

import java.util.List;

public interface CommentsService {

    List<Comments> findAll();

    Comments findById(int id);

    void save(Comments comments);

    void deleteById(int id);



}
