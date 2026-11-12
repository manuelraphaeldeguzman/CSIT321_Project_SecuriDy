package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.LessonQuestion;
import com.csit321g5.securidy.securidy.service.LessonQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson-questions")
@CrossOrigin(origins = "*")
public class LessonQuestionController {

    private final LessonQuestionService service;

    public LessonQuestionController(LessonQuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<LessonQuestion> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LessonQuestion getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/lesson/{lessonId}")
    public List<LessonQuestion> getByLessonId(
            @PathVariable String lessonId) {
        return service.getByLessonId(lessonId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LessonQuestion create(@RequestBody LessonQuestion entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public LessonQuestion update(
            @PathVariable String id,
            @RequestBody LessonQuestion entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
