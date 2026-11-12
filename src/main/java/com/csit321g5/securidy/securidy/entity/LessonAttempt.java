package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lesson_attempts")
public class LessonAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attempt_id")
    private Long attemptId;

    @Column(nullable = false)
    private Long lessonId;

    @Column(nullable = false)
    private Long userId;

    private Float score;

    private Integer timeSpent;

    private String completedAt;

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
