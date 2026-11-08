package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.ReadinessAssessment;
import com.csit321g5.securidy.securidy.repository.ReadinessAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadinessAssessmentService {

    private final ReadinessAssessmentRepository readinessAssessmentRepository;

    @Autowired
    public ReadinessAssessmentService(ReadinessAssessmentRepository readinessAssessmentRepository) {
        this.readinessAssessmentRepository = readinessAssessmentRepository;
    }

    public ReadinessAssessment createReadinessAssessment(ReadinessAssessment assessment) {
        return readinessAssessmentRepository.save(assessment);
    }

    public List<ReadinessAssessment> getAllReadinessAssessments() {
        return readinessAssessmentRepository.findAll();
    }

    public ReadinessAssessment getReadinessAssessmentById(String readinessId) {
        return readinessAssessmentRepository.findById(readinessId)
                .orElseThrow(() -> new RuntimeException("Readiness assessment not found with id: " + readinessId));
    }

    public List<ReadinessAssessment> getAssessmentsByUserId(String userId) {
        return readinessAssessmentRepository.findByUserId(userId);
    }

    public List<ReadinessAssessment> getAssessmentsByChapterId(String chapterId) {
        return readinessAssessmentRepository.findByChapterId(chapterId);
    }

    public List<ReadinessAssessment> getAssessmentsByUserIdAndChapterId(String userId, String chapterId) {
        return readinessAssessmentRepository.findByUserIdAndChapterId(userId, chapterId);
    }

    public ReadinessAssessment updateReadinessAssessment(String readinessId, ReadinessAssessment updatedDetails) {
        ReadinessAssessment existingAssessment = getReadinessAssessmentById(readinessId);

        if (updatedDetails.getUserId() != null) existingAssessment.setUserId(updatedDetails.getUserId());
        if (updatedDetails.getChapterId() != null) existingAssessment.setChapterId(updatedDetails.getChapterId());
        if (updatedDetails.getLessonAverage() != null) existingAssessment.setLessonAverage(updatedDetails.getLessonAverage());
        if (updatedDetails.getReviewQuizScore() != null) existingAssessment.setReviewQuizScore(updatedDetails.getReviewQuizScore());
        if (updatedDetails.getReadinessScore() != null) existingAssessment.setReadinessScore(updatedDetails.getReadinessScore());
        if (updatedDetails.getClassification() != null) existingAssessment.setClassification(updatedDetails.getClassification());
        if (updatedDetails.getRecommendedTopics() != null) existingAssessment.setRecommendedTopics(updatedDetails.getRecommendedTopics());
        if (updatedDetails.getGeneratedAt() != null) existingAssessment.setGeneratedAt(updatedDetails.getGeneratedAt());

        return readinessAssessmentRepository.save(existingAssessment);
    }

    public void deleteReadinessAssessment(String readinessId) {
        ReadinessAssessment assessment = getReadinessAssessmentById(readinessId);
        readinessAssessmentRepository.delete(assessment);
    }
}