package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, String> {

    // Find all answers associated with a specific quiz attempt
    List<QuizAnswer> findByAttemptId(String attemptId);

    // Find all answers submitted for a specific question across attempts
    List<QuizAnswer> findByQuestionId(String questionId);
}