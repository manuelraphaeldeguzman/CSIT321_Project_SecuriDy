package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.QuizQuestion;
import com.csit321g5.securidy.securidy.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionService {

    private final QuizQuestionRepository quizQuestionRepository;

    @Autowired
    public QuizQuestionService(QuizQuestionRepository quizQuestionRepository) {
        this.quizQuestionRepository = quizQuestionRepository;
    }

    public QuizQuestion createQuizQuestion(QuizQuestion quizQuestion) {
        return quizQuestionRepository.save(quizQuestion);
    }

    public List<QuizQuestion> getAllQuizQuestions() {
        return quizQuestionRepository.findAll();
    }

    public QuizQuestion getQuizQuestionById(String questionId) {
        return quizQuestionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Quiz question not found with id: " + questionId));
    }

    public List<QuizQuestion> getQuestionsByQuizId(String quizId) {
        return quizQuestionRepository.findByQuizIdOrderByOrderNoAsc(quizId);
    }

    public QuizQuestion updateQuizQuestion(String questionId, QuizQuestion updatedQuestionDetails) {
        QuizQuestion existingQuestion = getQuizQuestionById(questionId);

        if (updatedQuestionDetails.getQuizId() != null) existingQuestion.setQuizId(updatedQuestionDetails.getQuizId());
        if (updatedQuestionDetails.getQuestionText() != null) existingQuestion.setQuestionText(updatedQuestionDetails.getQuestionText());
        if (updatedQuestionDetails.getOption() != null) existingQuestion.setOption(updatedQuestionDetails.getOption());
        if (updatedQuestionDetails.getCorrectAnswers() != null) existingQuestion.setCorrectAnswers(updatedQuestionDetails.getCorrectAnswers());
        if (updatedQuestionDetails.getQuestionType() != null) existingQuestion.setQuestionType(updatedQuestionDetails.getQuestionType());
        if (updatedQuestionDetails.getPoints() != null) existingQuestion.setPoints(updatedQuestionDetails.getPoints());
        if (updatedQuestionDetails.getOrderNo() != null) existingQuestion.setOrderNo(updatedQuestionDetails.getOrderNo());

        return quizQuestionRepository.save(existingQuestion);
    }

    public void deleteQuizQuestion(String questionId) {
        QuizQuestion question = getQuizQuestionById(questionId);
        quizQuestionRepository.delete(question);
    }
}