package com.revature.quizzard.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor
@Entity @Table(name = "questions")
public class Question {

    @Id @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Embedded
    private Answers questionAnswers;

    @Embeddable
    @Data @NoArgsConstructor
    public static class Answers {

        @Column(name = "answer_a")
        private String answerA;

        @Column(name = "answer_b")
        private String answerB;

        @Column(name = "answer_c")
        private String answerC;

        @Column(name = "answer_d")
        private String answerD;

    }

}
