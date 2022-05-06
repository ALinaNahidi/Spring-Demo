package com.springdemo.storylab.service;

import com.springdemo.storylab.entity.Story;

import java.util.List;

public interface StoryService {

     List<Story> findAll();

     Story findById(int id);

     void save(Story story);

     void deleteById(int id);
}
