package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.Quiz;
import com.csit321g5.securidy.securidy.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(String quizId) {
        return quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + quizId));
    }

    public List<Quiz> getQuizzesByChapterId(String chapterId) {
        return quizRepository.findByChapterId(chapterId);
    }

    public List<Quiz> getQuizzesByType(String quizType) {
        return quizRepository.findByQuizType(quizType);
    }

    public Quiz updateQuiz(String quizId, Quiz updatedQuizDetails) {
        Quiz existingQuiz = getQuizById(quizId);

        if (updatedQuizDetails.getChapterId() != null) existingQuiz.setChapterId(updatedQuizDetails.getChapterId());
        if (updatedQuizDetails.getQuizType() != null) existingQuiz.setQuizType(updatedQuizDetails.getQuizType());
        if (updatedQuizDetails.getTitle() != null) existingQuiz.setTitle(updatedQuizDetails.getTitle());
        if (updatedQuizDetails.getDescription() != null) existingQuiz.setDescription(updatedQuizDetails.getDescription());
        if (updatedQuizDetails.getTimeLimit() != null) existingQuiz.setTimeLimit(updatedQuizDetails.getTimeLimit());
        if (updatedQuizDetails.getTotalPoints() != null) existingQuiz.setTotalPoints(updatedQuizDetails.getTotalPoints());

        return quizRepository.save(existingQuiz);
    }

    public void deleteQuiz(String quizId) {
        Quiz quiz = getQuizById(quizId);
        quizRepository.delete(quiz);
    }
}