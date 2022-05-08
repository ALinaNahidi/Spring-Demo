package com.springdemo.storylab.service;

import com.springdemo.storylab.dao.CommentsRepository;
import com.springdemo.storylab.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private CommentsRepository commentsDao;

    @Autowired
    public CommentsServiceImpl(CommentsRepository employeeDao){
        this.commentsDao =employeeDao;
    }


    @Override
    @Transactional
    public List<Comments> findAll() {
        return commentsDao.findAll();
    }

    @Override
    @Transactional
    public Comments findById(int id) {

        Optional<Comments> employeeOptional = commentsDao.findById(id);

        Comments comments = null;

        if (employeeOptional.isPresent()){
            comments = employeeOptional.get();
        }
        else {
            throw new RuntimeException("Employee Not Found:"+id);
        }
        return comments;
    }

    @Override
    @Transactional
    public void save(Comments story) {
        commentsDao.save(story);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        commentsDao.deleteById(id);

    }

}
