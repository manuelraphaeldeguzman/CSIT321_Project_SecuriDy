package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column(name = "lesson_id", nullable = false, updatable = false)
    private String lessonId;

    @Column(nullable = false)
    private Long chapterId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Integer orderNo;

    private String createdAt;

    @PrePersist
    protected void onCreate() {
        if (lessonId == null || lessonId.isBlank()) {
            lessonId = UUID.randomUUID().toString();
        }

        if (createdAt == null || createdAt.isBlank()) {
            createdAt = java.time.LocalDateTime.now().toString();
        }
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}