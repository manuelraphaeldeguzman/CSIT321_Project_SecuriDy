package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.Enrollment;
import com.csit321g5.securidy.securidy.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) { this.service = service; }

    @GetMapping
    public List<Enrollment> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Enrollment getById(@PathVariable String id) { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment create(@RequestBody Enrollment entity) { return service.create(entity); }

    @PutMapping("/{id}")
    public Enrollment update(@PathVariable String id, @RequestBody Enrollment entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) { service.delete(id); }
}
