package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.Quiz;
import com.csit321g5.securidy.securidy.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<List<Quiz>> getQuizzesByChapterId(@PathVariable String chapterId) {
        List<Quiz> quizzes = quizService.getQuizzesByChapterId(chapterId);
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/type/{quizType}")
    public ResponseEntity<List<Quiz>> getQuizzesByType(@PathVariable String quizType) {
        List<Quiz> quizzes = quizService.getQuizzesByType(quizType);
        return ResponseEntity.ok(quizzes);
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable String quizId, @RequestBody Quiz updatedQuiz) {
        Quiz quiz = quizService.updateQuiz(quizId, updatedQuiz);
        return ResponseEntity.ok(quiz);
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable String quizId) {
        quizService.deleteQuiz(quizId);
        return ResponseEntity.noContent().build();
    }
}