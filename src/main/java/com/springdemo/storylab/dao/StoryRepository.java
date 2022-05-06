package com.springdemo.storylab.dao;


import com.springdemo.storylab.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story,Integer> {


}
