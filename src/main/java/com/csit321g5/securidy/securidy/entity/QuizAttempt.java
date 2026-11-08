package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quiz_attempts")
public class QuizAttempt {
    @Id
    @Column(name = "attempt_id", nullable = false, updatable = false)
    private String attemptId;

    @Column(nullable = false)
    private String quizId;

    @Column(nullable = false)
    private String userId;

    private Float score;

    private Integer timeSpent;

    private String startedAt;

    private String completedAt;

    @PrePersist
    protected void onCreate() {
        if (attemptId == null || attemptId.isBlank()) attemptId = UUID.randomUUID().toString();
        if (startedAt == null || startedAt.isBlank()) startedAt = java.time.LocalDateTime.now().toString();
    }

    public String getAttemptId() { return attemptId; }
    public void setAttemptId(String attemptId) { this.attemptId = attemptId; }
    public String getQuizId() { return quizId; }
    public void setQuizId(String quizId) { this.quizId = quizId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Float getScore() { return score; }
    public void setScore(Float score) { this.score = score; }
    public Integer getTimeSpent() { return timeSpent; }
    public void setTimeSpent(Integer timeSpent) { this.timeSpent = timeSpent; }
    public String getStartedAt() { return startedAt; }
    public void setStartedAt(String startedAt) { this.startedAt = startedAt; }
    public String getCompletedAt() { return completedAt; }
    public void setCompletedAt(String completedAt) { this.completedAt = completedAt; }
}