package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.Lesson;
import com.csit321g5.securidy.securidy.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "*")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lesson> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Lesson getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson create(@RequestBody Lesson entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Lesson update(@PathVariable Long id, @RequestBody Lesson entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
