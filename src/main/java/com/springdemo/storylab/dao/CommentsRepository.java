package com.springdemo.storylab.dao;


import com.springdemo.storylab.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {

}
