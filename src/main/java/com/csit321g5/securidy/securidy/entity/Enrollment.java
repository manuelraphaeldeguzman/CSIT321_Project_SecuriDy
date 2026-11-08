package com.csit321g5.securidy.securidy.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @Column(name = "enrollment_id", nullable = false, updatable = false)
    private String enrollmentId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String courseId;

    private String dateEnrolled;
    private String status;

    @PrePersist
    protected void onCreate() {
        if (enrollmentId == null || enrollmentId.isBlank()) enrollmentId = UUID.randomUUID().toString();
        if (dateEnrolled == null || dateEnrolled.isBlank()) dateEnrolled = java.time.LocalDate.now().toString();
    }

    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public String getDateEnrolled() { return dateEnrolled; }
    public void setDateEnrolled(String dateEnrolled) { this.dateEnrolled = dateEnrolled; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
