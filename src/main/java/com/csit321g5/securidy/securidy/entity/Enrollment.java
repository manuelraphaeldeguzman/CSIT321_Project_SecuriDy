package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long courseId;

    private String dateEnrolled;
    private String status;
    private String createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null || createdAt.isBlank()) {
            createdAt = java.time.LocalDateTime.now().toString();
        }
    }

    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public String getDateEnrolled() { return dateEnrolled; }
    public void setDateEnrolled(String dateEnrolled) { this.dateEnrolled = dateEnrolled; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
