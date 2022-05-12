package com.springdemo.storylab.service;

import com.springdemo.storylab.dao.CommentsRepository;
import com.springdemo.storylab.entity.Comments;
import com.springdemo.storylab.exceptionhandling.StoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsServiceImpl(CommentsRepository commentsRepository){
        this.commentsRepository =commentsRepository;
    }


    @Override
    @Transactional
    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    @Transactional
    public Comments findById(int id) {

        Optional<Comments> employeeOptional = commentsRepository.findById(id);

        Comments comments = null;

        if (employeeOptional.isPresent()){
            comments = employeeOptional.get();
        }
        else {
            throw new StoryNotFoundException("Employee Not Found:"+id);
        }
        return comments;
    }

    @Override
    @Transactional
    public void save(Comments story) {
        commentsRepository.save(story);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        commentsRepository.deleteById(id);

    }

}
