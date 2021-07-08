package com.revature.quizzard.repos;

import com.revature.quizzard.entities.StudySet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudySetRepository extends JpaRepository<StudySet, Integer> {
}
