package com.revature.quizzard.services;

import com.revature.quizzard.entities.Question;
import com.revature.quizzard.repos.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepo;

    @Autowired
    public QuestionService(QuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }

    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepo.findAll();
    }

}
