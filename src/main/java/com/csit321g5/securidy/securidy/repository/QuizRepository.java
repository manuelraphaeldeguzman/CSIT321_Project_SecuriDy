package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

    List<Quiz> findByChapterId(String chapterId);

    List<Quiz> findByQuizType(String quizType);

    Optional<Quiz> findByTitle(String title);
}