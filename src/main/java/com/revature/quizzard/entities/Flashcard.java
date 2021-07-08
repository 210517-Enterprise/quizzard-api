package com.revature.quizzard.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor
@Entity @Table(name = "flashcards")
public class Flashcard {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(nullable = false)
    private String question;

    @NotEmpty
    @Column(nullable = false)
    private String answer;

    @NotNull
    @Column(nullable = false)
    private Category category;

    @NotNull
    @ManyToOne @JoinColumn
    private User creator;


    public Flashcard(@NotEmpty String question, @NotEmpty String answer) {
        this.question = (question != null) ? question : "";
        this.answer = (answer != null) ? answer : "";
        this.category = Category.OTHER;
    }

    public Flashcard(@NotEmpty String question, @NotEmpty String answer, @NotNull Category category) {
        this(question, answer);
        this.category = (category != null) ? category : Category.OTHER;
    }

    public Flashcard(@NotEmpty String question, @NotEmpty String answer, @NotNull Category category, @NotNull User creator) {
        this(question, answer, category);
        this.creator = creator;
    }
    

}
