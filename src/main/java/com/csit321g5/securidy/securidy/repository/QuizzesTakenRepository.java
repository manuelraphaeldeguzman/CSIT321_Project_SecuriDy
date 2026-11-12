package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.QuizzesTaken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzesTakenRepository
        extends JpaRepository<QuizzesTaken, Long> {
}