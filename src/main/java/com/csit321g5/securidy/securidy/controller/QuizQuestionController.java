package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.QuizQuestion;
import com.csit321g5.securidy.securidy.service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-questions")
public class QuizQuestionController {

    private final QuizQuestionService quizQuestionService;

    @Autowired
    public QuizQuestionController(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    @PostMapping
    public ResponseEntity<QuizQuestion> createQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        QuizQuestion createdQuestion = quizQuestionService.createQuizQuestion(quizQuestion);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizQuestion>> getAllQuizQuestions() {
        List<QuizQuestion> questions = quizQuestionService.getAllQuizQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuizQuestion> getQuizQuestionById(@PathVariable String questionId) {
        QuizQuestion question = quizQuestionService.getQuizQuestionById(questionId);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuizQuestion>> getQuestionsByQuizId(@PathVariable String quizId) {
        List<QuizQuestion> questions = quizQuestionService.getQuestionsByQuizId(quizId);
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<QuizQuestion> updateQuizQuestion(@PathVariable String questionId, @RequestBody QuizQuestion updatedQuestion) {
        QuizQuestion question = quizQuestionService.updateQuizQuestion(questionId, updatedQuestion);
        return ResponseEntity.ok(question);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuizQuestion(@PathVariable String questionId) {
        quizQuestionService.deleteQuizQuestion(questionId);
        return ResponseEntity.noContent().build();
    }
}