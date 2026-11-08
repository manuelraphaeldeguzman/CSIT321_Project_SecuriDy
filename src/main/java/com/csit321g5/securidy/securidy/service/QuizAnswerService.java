package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.QuizAnswer;
import com.csit321g5.securidy.securidy.repository.QuizAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAnswerService {

    private final QuizAnswerRepository quizAnswerRepository;

    @Autowired
    public QuizAnswerService(QuizAnswerRepository quizAnswerRepository) {
        this.quizAnswerRepository = quizAnswerRepository;
    }

    public QuizAnswer createQuizAnswer(QuizAnswer quizAnswer) {
        return quizAnswerRepository.save(quizAnswer);
    }

    public List<QuizAnswer> getAllQuizAnswers() {
        return quizAnswerRepository.findAll();
    }

    public QuizAnswer getQuizAnswerById(String answerId) {
        return quizAnswerRepository.findById(answerId)
                .orElseThrow(() -> new RuntimeException("Quiz answer not found with id: " + answerId));
    }

    public List<QuizAnswer> getAnswersByAttemptId(String attemptId) {
        return quizAnswerRepository.findByAttemptId(attemptId);
    }

    public List<QuizAnswer> getAnswersByQuestionId(String questionId) {
        return quizAnswerRepository.findByQuestionId(questionId);
    }

    public QuizAnswer updateQuizAnswer(String answerId, QuizAnswer updatedAnswerDetails) {
        QuizAnswer existingAnswer = getQuizAnswerById(answerId);

        if (updatedAnswerDetails.getAttemptId() != null) existingAnswer.setAttemptId(updatedAnswerDetails.getAttemptId());
        if (updatedAnswerDetails.getQuestionId() != null) existingAnswer.setQuestionId(updatedAnswerDetails.getQuestionId());
        if (updatedAnswerDetails.getSelectedAnswer() != null) existingAnswer.setSelectedAnswer(updatedAnswerDetails.getSelectedAnswer());
        if (updatedAnswerDetails.getIsCorrect() != null) existingAnswer.setIsCorrect(updatedAnswerDetails.getIsCorrect());
        if (updatedAnswerDetails.getPoints() != null) existingAnswer.setPoints(updatedAnswerDetails.getPoints());

        return quizAnswerRepository.save(existingAnswer);
    }

    public void deleteQuizAnswer(String answerId) {
        QuizAnswer answer = getQuizAnswerById(answerId);
        quizAnswerRepository.delete(answer);
    }
}