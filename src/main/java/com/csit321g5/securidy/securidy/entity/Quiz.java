package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @Column(name = "quiz_id", nullable = false, updatable = false)
    private String quizId;

    @Column(nullable = false)
    private String chapterId;

    @Column(nullable = false)
    private String quizType;

    @Column(nullable = false)
    private String title;

    private String description;

    private Integer timeLimit;

    private Integer totalPoints;

    private String createdAt;

    @PrePersist
    protected void onCreate() {
        if (quizId == null || quizId.isBlank()) quizId = UUID.randomUUID().toString();
        if (createdAt == null || createdAt.isBlank()) createdAt = java.time.LocalDateTime.now().toString();
    }

    public String getQuizId() { return quizId; }
    public void setQuizId(String quizId) { this.quizId = quizId; }
    public String getChapterId() { return chapterId; }
    public void setChapterId(String chapterId) { this.chapterId = chapterId; }
    public String getQuizType() { return quizType; }
    public void setQuizType(String quizType) { this.quizType = quizType; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getTimeLimit() { return timeLimit; }
    public void setTimeLimit(Integer timeLimit) { this.timeLimit = timeLimit; }
    public Integer getTotalPoints() { return totalPoints; }
    public void setTotalPoints(Integer totalPoints) { this.totalPoints = totalPoints; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}