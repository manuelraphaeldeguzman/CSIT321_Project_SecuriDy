package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, String> {

    // Find all attempts made by a specific user
    List<QuizAttempt> findByUserId(String userId);

    // Find all attempts for a specific quiz
    List<QuizAttempt> findByQuizId(String quizId);

    // Find attempts for a specific user on a specific quiz
    List<QuizAttempt> findByUserIdAndQuizId(String userId, String quizId);
}