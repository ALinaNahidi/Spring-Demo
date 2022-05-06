package com.springdemo.storylab.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "story")
@Getter
@Setter
public class Story {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty(message = "Title cannot be empty!")
    @Column(name="title")
    private String title;

    @Column(name="author_name")
    private String authorName;

    @NotBlank(message = "Story description can not be Blank!")
    @Column(name="story_description")
    private String description;

    @NotEmpty(message = "Story must have a Moral")
    @Column(name="moral")
    private String moral;


    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="story",
            cascade= CascadeType.ALL)
    private List<Comments> comments ;


    public Story(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }

    public Story() {
    }



    public void addComment(Comments theComment) {

        if(comments==null){
            comments = new ArrayList<>();
        }

        comments.add(theComment);
        theComment.setStory(this);


    }

    @Override
    public String toString(){
        return id+" "+title+" "+authorName+" "+moral;
    }


}
