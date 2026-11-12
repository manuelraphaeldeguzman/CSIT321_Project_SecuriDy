
package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chapters_taken")
public class ChaptersTaken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chapters_taken_id")
    private Long chaptersTakenId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "chapter_id", nullable = false)
    private Long chapterId;

    @Column(nullable = false)
    private String status;

    @Column(name = "started_at")
    private String startedAt;

    @Column(name = "completed_at")
    private String completedAt;

    @PrePersist
    protected void onCreate() {
        if (startedAt == null || startedAt.isBlank()) {
            startedAt = java.time.LocalDateTime.now().toString();
        }

        if (status == null || status.isBlank()) {
            status = "Not Started";
        }
    }

    public Long getChaptersTakenId() { return chaptersTakenId; }
    public void setChaptersTakenId(Long chaptersTakenId) { this.chaptersTakenId = chaptersTakenId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getChapterId() { return chapterId; }
    public void setChapterId(Long chapterId) { this.chapterId = chapterId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStartedAt() { return startedAt; }
    public void setStartedAt(String startedAt) { this.startedAt = startedAt; }

    public String getCompletedAt() { return completedAt; }
    public void setCompletedAt(String completedAt) { this.completedAt = completedAt; }
}
