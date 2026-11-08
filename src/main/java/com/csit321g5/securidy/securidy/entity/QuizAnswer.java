package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quiz_answers")
public class QuizAnswer {
    @Id
    @Column(name = "answer_id", nullable = false, updatable = false)
    private String answerId;

    @Column(nullable = false)
    private String attemptId;

    @Column(nullable = false)
    private String questionId;

    private String selectedAnswer;

    private Boolean isCorrect;

    private Integer points;

    @PrePersist
    protected void onCreate() {
        if (answerId == null || answerId.isBlank()) answerId = UUID.randomUUID().toString();
    }

    public String getAnswerId() { return answerId; }
    public void setAnswerId(String answerId) { this.answerId = answerId; }
    public String getAttemptId() { return attemptId; }
    public void setAttemptId(String attemptId) { this.attemptId = attemptId; }
    public String getQuestionId() { return questionId; }
    public void setQuestionId(String questionId) { this.questionId = questionId; }
    public String getSelectedAnswer() { return selectedAnswer; }
    public void setSelectedAnswer(String selectedAnswer) { this.selectedAnswer = selectedAnswer; }
    public Boolean getIsCorrect() { return isCorrect; }
    public void setIsCorrect(Boolean isCorrect) { this.isCorrect = isCorrect; }
    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
}