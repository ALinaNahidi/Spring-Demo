package com.springdemo.storylab.service;

import com.springdemo.storylab.dao.StoryRepository;
import com.springdemo.storylab.entity.Story;
import com.springdemo.storylab.exceptionhandling.StoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {

    private StoryRepository storyRepository;

    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository){
        this.storyRepository =storyRepository;
    }


    @Override
    @Transactional
    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    @Override
    @Transactional
    public Story findById(int id) {

        Optional<Story> employeeOptional = storyRepository.findById(id);

        Story story = null;

        if (employeeOptional.isPresent()){
            story = employeeOptional.get();
        }
        else {
            throw new StoryNotFoundException("Employee Not Found:"+id);
        }
        return story;
    }

    @Override
    @Transactional
    public void save(Story story) {
        storyRepository.save(story);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        storyRepository.deleteById(id);

    }
}
