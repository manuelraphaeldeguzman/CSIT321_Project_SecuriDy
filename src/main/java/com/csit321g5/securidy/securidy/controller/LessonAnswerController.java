package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.LessonAnswer;
import com.csit321g5.securidy.securidy.service.LessonAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson-answers")
@CrossOrigin(origins = "*")
public class LessonAnswerController {

    private final LessonAnswerService service;

    public LessonAnswerController(LessonAnswerService service) {
        this.service = service;
    }

    @GetMapping
    public List<LessonAnswer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LessonAnswer getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LessonAnswer create(@RequestBody LessonAnswer entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public LessonAnswer update(
            @PathVariable String id,
            @RequestBody LessonAnswer entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
