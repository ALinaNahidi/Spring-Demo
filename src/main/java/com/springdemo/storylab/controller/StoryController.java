package com.springdemo.storylab.controller;

import com.springdemo.storylab.entity.Comments;
import com.springdemo.storylab.entity.Story;
import com.springdemo.storylab.service.CommentsService;
import com.springdemo.storylab.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;




@Controller
public class StoryController {

    private StoryService storyService;

    private CommentsService commentsService;

    private final static String storyFrom = "storyLab/story-form";

    @Autowired
    public StoryController(StoryService storyService, CommentsService commentsService) {
        this.storyService = storyService;
        this.commentsService = commentsService;
    }




    @GetMapping("/list-stories")
    public String listStories(Model model){

        List<Story> employeeList = storyService.findAll();
        model.addAttribute("story",employeeList);

        return "storyLab/list-stories";
    }


    @GetMapping("/story-form")
    public String showFormForAdd(Model model){

        String username = getCurrentUserName();

        model.addAttribute("story",new Story());

        model.addAttribute("username",username);

        return storyFrom;
    }


    @PostMapping("/save")
    public String saveStory(@Valid @ModelAttribute("story") Story story,
                            BindingResult theBindingResult){

        if (theBindingResult.hasErrors()){
            return storyFrom;
        }

        String username = getCurrentUserName();
        story.setAuthorName(username);
        storyService.save(story);

        return "redirect:/list-stories";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("storyId") int id,Model model){

        String username = getCurrentUserName();
        Story theStory = storyService.findById(id);

        model.addAttribute("story",theStory);
        model.addAttribute("username",username);

        return storyFrom;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("storyId") int theId) {

        storyService.deleteById(theId);

        return "redirect:/list-stories";

    }



    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute("myStory") ReadComment readComment,
                              @RequestParam(value = "currentStory",required = false) int storyId,
                              Model model
                              ){


        Comments comments = readComment.getCommentsObject();
        Story storyUpdate = readComment.getStoryObject();

        storyService.save(storyUpdate);
        commentsService.save(comments);

        storyUpdate.addComment(comments);
        storyService.save(storyUpdate);

        model.addAttribute("myStory",new ReadComment(storyUpdate,new Comments()));

        return "storyLab/successfulComment";
    }


    @GetMapping("/read-story")
    public String readStory( @RequestParam(value = "currentStory",required = false) Integer storyId , Model model) {

        Story story = storyService.findById(storyId);
        Comments comments = new Comments();

        ReadComment readComment = new ReadComment(story,comments);

        model.addAttribute("myStory",readComment);

        return "storyLab/read-story";

    }

    private String getCurrentUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
