package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lesson_attempts")
public class LessonAttempt {

    @Id
    @Column(name = "attempt_id", nullable = false, updatable = false)
    private String attemptId;

    @Column(nullable = false)
    private String lessonId;

    @Column(nullable = false)
    private String userId;

    private Float score;

    private Integer timeSpent;

    private String completedAt;

    @PrePersist
    protected void onCreate() {
        if (attemptId == null || attemptId.isBlank()) {
            attemptId = UUID.randomUUID().toString();
        }
    }

    public String getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(String attemptId) {
        this.attemptId = attemptId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }
}
