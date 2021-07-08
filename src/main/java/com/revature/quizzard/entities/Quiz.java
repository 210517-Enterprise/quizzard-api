package com.revature.quizzard.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class Quiz {

    @Id @Column
    private int id;

    @Column(nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "quiz_questions",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    public Quiz(Category category, User creator) {
        this.category = category;
        this.creator = creator;
    }

    public Quiz(Category category, List<Question> questions, User creator) {
        this(category, creator);
        this.questions = questions;
    }


}
