package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quiz_questions")
public class QuizQuestion {
    @Id
    @Column(name = "question_id", nullable = false, updatable = false)
    private String questionId;

    @Column(nullable = false)
    private String quizId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionText;

    private String option;

    @Column(nullable = false)
    private String correctAnswers; // or correctAnwer based on diagram spelling

    @Column(nullable = false)
    private String questionType;

    private Integer points;

    private Integer orderNo;

    @PrePersist
    protected void onCreate() {
        if (questionId == null || questionId.isBlank()) questionId = UUID.randomUUID().toString();
    }

    public String getQuestionId() { return questionId; }
    public void setQuestionId(String questionId) { this.questionId = questionId; }
    public String getQuizId() { return quizId; }
    public void setQuizId(String quizId) { this.quizId = quizId; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public String getOption() { return option; }
    public void setOption(String option) { this.option = option; }
    public String getCorrectAnswer() { return correctAnswers; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswers = correctAnswer; }
    public String getQuestionType() { return questionType; }
    public void setQuestionType(String questionType) { this.questionType = questionType; }
    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
    public Integer getOrderNo() { return orderNo; }
    public void setOrderNo(Integer orderNo) { this.orderNo = orderNo; }
}