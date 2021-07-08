package com.revature.quizzard.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity @Table(name = "study_sets")
public class StudySet {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private User owner;

    @ManyToMany
    @JoinTable(
        name = "study_set_cards",
        joinColumns = @JoinColumn(name = "study_set_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "flashcard_id", nullable = false)
    )
    private List<Flashcard> studySetCards;

    public StudySet() {
        studySetCards = new ArrayList<>();
    }

    public StudySet(@NotEmpty String name, @NotNull User owner) {
        this();
        this.name = name;
        this.owner = owner;
    }

    public StudySet addFlashcardToStudySet(Flashcard flashcard) {
        studySetCards.add(flashcard);
        return this;
    }

}
