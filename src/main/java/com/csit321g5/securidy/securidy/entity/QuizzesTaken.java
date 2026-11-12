
package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quizzes_taken")
public class QuizzesTaken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quizzes_taken_id")
    private Long quizzesTakenId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "quiz_id", nullable = false)
    private String quizId;

    @Column(nullable = false)
    private String status;

    @Column(name = "started_at")
    private String startedAt;

    @Column(name = "ended_at")
    private String endedAt;

    @PrePersist
    protected void onCreate() {
        if (startedAt == null || startedAt.isBlank()) {
            startedAt = java.time.LocalDateTime.now().toString();
        }

        if (status == null || status.isBlank()) {
            status = "Not Started";
        }
    }

    public Long getQuizzesTakenId() { return quizzesTakenId; }
    public void setQuizzesTakenId(Long quizzesTakenId) { this.quizzesTakenId = quizzesTakenId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getQuizId() { return quizId; }
    public void setQuizId(String quizId) { this.quizId = quizId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStartedAt() { return startedAt; }
    public void setStartedAt(String startedAt) { this.startedAt = startedAt; }

    public String getEndedAt() { return endedAt; }
    public void setEndedAt(String endedAt) { this.endedAt = endedAt; }
}
