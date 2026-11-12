package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.LessonAttempt;
import com.csit321g5.securidy.securidy.service.LessonAttemptService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson-attempts")
@CrossOrigin(origins = "*")
public class LessonAttemptController {

    private final LessonAttemptService service;

    public LessonAttemptController(LessonAttemptService service) {
        this.service = service;
    }

    @GetMapping
    public List<LessonAttempt> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LessonAttempt getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LessonAttempt create(@RequestBody LessonAttempt entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public LessonAttempt update(
            @PathVariable String id,
            @RequestBody LessonAttempt entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
