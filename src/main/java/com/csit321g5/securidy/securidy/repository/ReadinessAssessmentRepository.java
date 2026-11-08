package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.ReadinessAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadinessAssessmentRepository extends JpaRepository<ReadinessAssessment, String> {

    // Find all assessments for a specific user
    List<ReadinessAssessment> findByUserId(String userId);

    // Find all assessments for a specific chapter
    List<ReadinessAssessment> findByChapterId(String chapterId);

    // Find a specific user's assessment for a specific chapter
    List<ReadinessAssessment> findByUserIdAndChapterId(String userId, String chapterId);
}