package com.springdemo.storylab.service;

import com.springdemo.storylab.dao.StoryRepository;
import com.springdemo.storylab.entity.Story;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class StoryServiceImplTest {


    @Autowired
    private StoryService storyService;

    @MockBean
    private StoryRepository storyRepository;

    @Test
    void findById() {

        Story story = new Story();
        story.setId(9);
        story.setAuthorName("author1");
        story.setTitle("The Lion and The Mouse");
        story.setDescription("When a lion was resting in the jungle, a mouse began racing up and down his body for amusement. The lion’s sleep was interrupted, and he awoke enraged. The lion was going to eat the mouse when the mouse begged him to let him go. “I assure you, if you save me, I will be of immense help to you in the future.” The lion laughed at the mouse’s self-assurance and freed him.\n" +
                "\n" +
                "A group of hunters arrived in the forest one day and captured the lion. They had him tied to a tree. The lion began to roar as he struggled to get out. Soon, the mouse passed by and spotted the lion in distress. He dashed off, biting on the ropes to free the lion, and the two hurried off into the woods.");
        story.setMoral("Always be kind to one another. ");

        Mockito.when(storyRepository.findById(9)).thenReturn(Optional.of(story));
        assertThat(storyService.findById(9)).isEqualTo(story);

    }




    @Test
    void findAll() {
        Story story1 = new Story();
        story1.setId(9);
        story1.setAuthorName("author1");
        story1.setTitle("The Lion and The Mouse");
        story1.setDescription("When a lion was resting in the jungle, a mouse began racing up and down his body for amusement. The lion’s sleep was interrupted, and he awoke enraged. The lion was going to eat the mouse when the mouse begged him to let him go. “I assure you, if you save me, I will be of immense help to you in the future.” The lion laughed at the mouse’s self-assurance and freed him.\n" +
                "\n" +
                "A group of hunters arrived in the forest one day and captured the lion. They had him tied to a tree. The lion began to roar as he struggled to get out. Soon, the mouse passed by and spotted the lion in distress. He dashed off, biting on the ropes to free the lion, and the two hurried off into the woods.");
        story1.setMoral("Always be kind to one another. ");

        Story story2 = new Story();
        story2.setId(10);
        story2.setAuthorName("author1");
        story2.setTitle("The Lion and The Mouse");
        story2.setDescription("When a lion was resting in the jungle, a mouse began racing up and down his body for amusement. The lion’s sleep was interrupted, and he awoke enraged. The lion was going to eat the mouse when the mouse begged him to let him go. “I assure you, if you save me, I will be of immense help to you in the future.” The lion laughed at the mouse’s self-assurance and freed him.\n" +
                "\n" +
                "A group of hunters arrived in the forest one day and captured the lion. They had him tied to a tree. The lion began to roar as he struggled to get out. Soon, the mouse passed by and spotted the lion in distress. He dashed off, biting on the ropes to free the lion, and the two hurried off into the woods.");
        story2.setMoral("Always be kind to one another. ");

        List<Story> stories = new ArrayList<>();
        stories.add(story1);
        stories.add(story2);

        Mockito.when(storyRepository.findAll()).thenReturn(stories);

        assertThat(storyService.findAll()).isEqualTo(stories);
    }
}