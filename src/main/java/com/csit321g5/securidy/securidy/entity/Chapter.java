package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @Column(name = "chapter_id", nullable = false, updatable = false)
    private String chapterId;

    @Column(nullable = false)
    private String courseId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer orderNo;

    private String createdAt;

    @PrePersist
    protected void onCreate() {
        if (chapterId == null || chapterId.isBlank()) chapterId = UUID.randomUUID().toString();
        if (createdAt == null || createdAt.isBlank()) createdAt = java.time.LocalDateTime.now().toString();
    }

    public String getChapterId() { return chapterId; }
    public void setChapterId(String chapterId) { this.chapterId = chapterId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getOrderNo() { return orderNo; }
    public void setOrderNo(Integer orderNo) { this.orderNo = orderNo; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
