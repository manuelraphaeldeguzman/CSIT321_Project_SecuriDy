package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.QuizzesTaken;
import com.csit321g5.securidy.securidy.service.QuizzesTakenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes-taken")
@CrossOrigin(origins = "*")
public class QuizzesTakenController {

    private final QuizzesTakenService service;

    public QuizzesTakenController(QuizzesTakenService service) {
        this.service = service;
    }

    @GetMapping
    public List<QuizzesTaken> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public QuizzesTaken getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuizzesTaken create(@RequestBody QuizzesTaken entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public QuizzesTaken update(@PathVariable Long id, @RequestBody QuizzesTaken entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}