package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.ReadinessAssessment;
import com.csit321g5.securidy.securidy.service.ReadinessAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readiness-assessments")
public class ReadinessAssessmentController {

    private final ReadinessAssessmentService readinessAssessmentService;

    @Autowired
    public ReadinessAssessmentController(ReadinessAssessmentService readinessAssessmentService) {
        this.readinessAssessmentService = readinessAssessmentService;
    }

    @PostMapping
    public ResponseEntity<ReadinessAssessment> createReadinessAssessment(@RequestBody ReadinessAssessment assessment) {
        ReadinessAssessment createdAssessment = readinessAssessmentService.createReadinessAssessment(assessment);
        return new ResponseEntity<>(createdAssessment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReadinessAssessment>> getAllReadinessAssessments() {
        List<ReadinessAssessment> assessments = readinessAssessmentService.getAllReadinessAssessments();
        return ResponseEntity.ok(assessments);
    }

    @GetMapping("/{readinessId}")
    public ResponseEntity<ReadinessAssessment> getReadinessAssessmentById(@PathVariable String readinessId) {
        ReadinessAssessment assessment = readinessAssessmentService.getReadinessAssessmentById(readinessId);
        return ResponseEntity.ok(assessment);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReadinessAssessment>> getAssessmentsByUserId(@PathVariable String userId) {
        List<ReadinessAssessment> assessments = readinessAssessmentService.getAssessmentsByUserId(userId);
        return ResponseEntity.ok(assessments);
    }

    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<List<ReadinessAssessment>> getAssessmentsByChapterId(@PathVariable String chapterId) {
        List<ReadinessAssessment> assessments = readinessAssessmentService.getAssessmentsByChapterId(chapterId);
        return ResponseEntity.ok(assessments);
    }

    @PutMapping("/{readinessId}")
    public ResponseEntity<ReadinessAssessment> updateReadinessAssessment(@PathVariable String readinessId, @RequestBody ReadinessAssessment updatedAssessment) {
        ReadinessAssessment assessment = readinessAssessmentService.updateReadinessAssessment(readinessId, updatedAssessment);
        return ResponseEntity.ok(assessment);
    }

    @DeleteMapping("/{readinessId}")
    public ResponseEntity<Void> deleteReadinessAssessment(@PathVariable String readinessId) {
        readinessAssessmentService.deleteReadinessAssessment(readinessId);
        return ResponseEntity.noContent().build();
    }
}