package com.revature.quizzard.repos;

import com.revature.quizzard.entities.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {

    List<Flashcard> findFlashcardsByCategory(String category);
    List<Flashcard> findFlashcardsByCreatorId(int creatorId);

}
