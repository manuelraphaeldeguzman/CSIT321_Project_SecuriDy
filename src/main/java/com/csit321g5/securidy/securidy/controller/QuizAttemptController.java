package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.QuizAttempt;
import com.csit321g5.securidy.securidy.service.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-attempts")
public class QuizAttemptController {

    private final QuizAttemptService quizAttemptService;

    @Autowired
    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    @PostMapping
    public ResponseEntity<QuizAttempt> createQuizAttempt(@RequestBody QuizAttempt quizAttempt) {
        QuizAttempt createdAttempt = quizAttemptService.createQuizAttempt(quizAttempt);
        return new ResponseEntity<>(createdAttempt, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizAttempt>> getAllQuizAttempts() {
        List<QuizAttempt> attempts = quizAttemptService.getAllQuizAttempts();
        return ResponseEntity.ok(attempts);
    }

    @GetMapping("/{attemptId}")
    public ResponseEntity<QuizAttempt> getQuizAttemptById(@PathVariable String attemptId) {
        QuizAttempt attempt = quizAttemptService.getQuizAttemptById(attemptId);
        return ResponseEntity.ok(attempt);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<QuizAttempt>> getAttemptsByUserId(@PathVariable String userId) {
        List<QuizAttempt> attempts = quizAttemptService.getAttemptsByUserId(userId);
        return ResponseEntity.ok(attempts);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuizAttempt>> getAttemptsByQuizId(@PathVariable String quizId) {
        List<QuizAttempt> attempts = quizAttemptService.getAttemptsByQuizId(quizId);
        return ResponseEntity.ok(attempts);
    }

    @PutMapping("/{attemptId}")
    public ResponseEntity<QuizAttempt> updateQuizAttempt(@PathVariable String attemptId, @RequestBody QuizAttempt updatedAttempt) {
        QuizAttempt attempt = quizAttemptService.updateQuizAttempt(attemptId, updatedAttempt);
        return ResponseEntity.ok(attempt);
    }

    @DeleteMapping("/{attemptId}")
    public ResponseEntity<Void> deleteQuizAttempt(@PathVariable String attemptId) {
        quizAttemptService.deleteQuizAttempt(attemptId);
        return ResponseEntity.noContent().build();
    }
}