package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.Course;
import com.csit321g5.securidy.securidy.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) { this.service = service; }

    @GetMapping
    public List<Course> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody Course entity) { return service.create(entity); }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
