package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "readiness_assessments")
public class ReadinessAssessment {
    @Id
    @Column(name = "readiness_id", nullable = false, updatable = false)
    private String readinessId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String chapterId;

    private Float lessonAverage;

    private Float reviewQuizScore;

    private Float readinessScore;

    private String classification;

    private String recommendedTopics;

    private String generatedAt;

    @PrePersist
    protected void onCreate() {
        if (readinessId == null || readinessId.isBlank()) readinessId = UUID.randomUUID().toString();
        if (generatedAt == null || generatedAt.isBlank()) generatedAt = java.time.LocalDateTime.now().toString();
    }

    public String getReadinessId() { return readinessId; }
    public void setReadinessId(String readinessId) { this.readinessId = readinessId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getChapterId() { return chapterId; }
    public void setChapterId(String chapterId) { this.chapterId = chapterId; }
    public Float getLessonAverage() { return lessonAverage; }
    public void setLessonAverage(Float lessonAverage) { this.lessonAverage = lessonAverage; }
    public Float getReviewQuizScore() { return reviewQuizScore; }
    public void setReviewQuizScore(Float reviewQuizScore) { this.reviewQuizScore = reviewQuizScore; }
    public Float getReadinessScore() { return readinessScore; }
    public void setReadinessScore(Float readinessScore) { this.readinessScore = readinessScore; }
    public String getClassification() { return classification; }
    public void setClassification(String classification) { this.classification = classification; }
    public String getRecommendedTopics() { return recommendedTopics; }
    public void setRecommendedTopics(String recommendedTopics) { this.recommendedTopics = recommendedTopics; }
    public String getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(String generatedAt) { this.generatedAt = generatedAt; }
}