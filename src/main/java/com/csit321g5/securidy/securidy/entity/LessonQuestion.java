package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lesson_questions")
public class LessonQuestion {

    @Id
    @Column(name = "question_id", nullable = false, updatable = false)
    private String questionId;

    @Column(nullable = false)
    private String lessonId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questionText;

    @Column(name = "option", columnDefinition = "TEXT")
    private String option;

    @Column(nullable = false)
    private String correctAnswer;

    @Column(nullable = false)
    private String questionType;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private Integer orderNo;

    @PrePersist
    protected void onCreate() {
        if (questionId == null || questionId.isBlank()) {
            questionId = UUID.randomUUID().toString();
        }
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
