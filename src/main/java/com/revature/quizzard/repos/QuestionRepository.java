package com.revature.quizzard.repos;

import com.revature.quizzard.entities.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
