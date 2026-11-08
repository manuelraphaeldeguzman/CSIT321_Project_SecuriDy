package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.QuizAttempt;
import com.csit321g5.securidy.securidy.repository.QuizAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAttemptService {

    private final QuizAttemptRepository quizAttemptRepository;

    @Autowired
    public QuizAttemptService(QuizAttemptRepository quizAttemptRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
    }

    public QuizAttempt createQuizAttempt(QuizAttempt quizAttempt) {
        return quizAttemptRepository.save(quizAttempt);
    }

    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptRepository.findAll();
    }

    public QuizAttempt getQuizAttemptById(String attemptId) {
        return quizAttemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Quiz attempt not found with id: " + attemptId));
    }

    public List<QuizAttempt> getAttemptsByUserId(String userId) {
        return quizAttemptRepository.findByUserId(userId);
    }

    public List<QuizAttempt> getAttemptsByQuizId(String quizId) {
        return quizAttemptRepository.findByQuizId(quizId);
    }

    public List<QuizAttempt> getAttemptsByUserIdAndQuizId(String userId, String quizId) {
        return quizAttemptRepository.findByUserIdAndQuizId(userId, quizId);
    }

    public QuizAttempt updateQuizAttempt(String attemptId, QuizAttempt updatedAttemptDetails) {
        QuizAttempt existingAttempt = getQuizAttemptById(attemptId);

        if (updatedAttemptDetails.getQuizId() != null) existingAttempt.setQuizId(updatedAttemptDetails.getQuizId());
        if (updatedAttemptDetails.getUserId() != null) existingAttempt.setUserId(updatedAttemptDetails.getUserId());
        if (updatedAttemptDetails.getScore() != null) existingAttempt.setScore(updatedAttemptDetails.getScore());
        if (updatedAttemptDetails.getTimeSpent() != null) existingAttempt.setTimeSpent(updatedAttemptDetails.getTimeSpent());
        if (updatedAttemptDetails.getStartedAt() != null) existingAttempt.setStartedAt(updatedAttemptDetails.getStartedAt());
        if (updatedAttemptDetails.getCompletedAt() != null) existingAttempt.setCompletedAt(updatedAttemptDetails.getCompletedAt());

        return quizAttemptRepository.save(existingAttempt);
    }

    public void deleteQuizAttempt(String attemptId) {
        QuizAttempt attempt = getQuizAttemptById(attemptId);
        quizAttemptRepository.delete(attempt);
    }
}