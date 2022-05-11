package com.springdemo.storylab;

import com.springdemo.storylab.controller.StoryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class StoryLabApplicationTests {

	@Autowired
	private StoryController storyController;

	@Test
	void contextLoads() throws Exception {
		assertThat(storyController).isNotNull();
	}

}
