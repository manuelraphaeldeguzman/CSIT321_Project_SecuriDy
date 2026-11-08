package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, String> {

    // Find all questions belonging to a specific quiz
    List<QuizQuestion> findByQuizId(String quizId);

    // Find questions by quiz ID ordered by orderNo
    List<QuizQuestion> findByQuizIdOrderByOrderNoAsc(String quizId);
}