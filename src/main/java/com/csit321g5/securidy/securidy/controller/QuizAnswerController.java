package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.QuizAnswer;
import com.csit321g5.securidy.securidy.service.QuizAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-answers")
public class QuizAnswerController {

    private final QuizAnswerService quizAnswerService;

    @Autowired
    public QuizAnswerController(QuizAnswerService quizAnswerService) {
        this.quizAnswerService = quizAnswerService;
    }

    @PostMapping
    public ResponseEntity<QuizAnswer> createQuizAnswer(@RequestBody QuizAnswer quizAnswer) {
        QuizAnswer createdAnswer = quizAnswerService.createQuizAnswer(quizAnswer);
        return new ResponseEntity<>(createdAnswer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizAnswer>> getAllQuizAnswers() {
        List<QuizAnswer> answers = quizAnswerService.getAllQuizAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<QuizAnswer> getQuizAnswerById(@PathVariable String answerId) {
        QuizAnswer answer = quizAnswerService.getQuizAnswerById(answerId);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/attempt/{attemptId}")
    public ResponseEntity<List<QuizAnswer>> getAnswersByAttemptId(@PathVariable String attemptId) {
        List<QuizAnswer> answers = quizAnswerService.getAnswersByAttemptId(attemptId);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<QuizAnswer>> getAnswersByQuestionId(@PathVariable String questionId) {
        List<QuizAnswer> answers = quizAnswerService.getAnswersByQuestionId(questionId);
        return ResponseEntity.ok(answers);
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<QuizAnswer> updateQuizAnswer(@PathVariable String answerId, @RequestBody QuizAnswer updatedAnswer) {
        QuizAnswer answer = quizAnswerService.updateQuizAnswer(answerId, updatedAnswer);
        return ResponseEntity.ok(answer);
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<Void> deleteQuizAnswer(@PathVariable String answerId) {
        quizAnswerService.deleteQuizAnswer(answerId);
        return ResponseEntity.noContent().build();
    }
}