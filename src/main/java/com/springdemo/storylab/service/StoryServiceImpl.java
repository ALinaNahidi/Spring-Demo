package com.springdemo.storylab.service;

import com.springdemo.storylab.dao.StoryRepository;
import com.springdemo.storylab.entity.Story;
import com.springdemo.storylab.exceptionhandling.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {

    private StoryRepository employeeDao;

    @Autowired
    public StoryServiceImpl(StoryRepository employeeDao){
        this.employeeDao=employeeDao;
    }


    @Override
    @Transactional
    public List<Story> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Story findById(int id) {

        Optional<Story> employeeOptional = employeeDao.findById(id);

        Story story = null;

        if (employeeOptional.isPresent()){
            story = employeeOptional.get();
        }
        else {
            throw new EmployeeNotFoundException("Employee Not Found:"+id);
        }
        return story;
    }

    @Override
    @Transactional
    public void save(Story story) {
        employeeDao.save(story);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);

    }
}
