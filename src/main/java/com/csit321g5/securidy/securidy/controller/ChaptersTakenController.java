package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.ChaptersTaken;
import com.csit321g5.securidy.securidy.service.ChaptersTakenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters-taken")
@CrossOrigin(origins = "*")
public class ChaptersTakenController {

    private final ChaptersTakenService service;

    public ChaptersTakenController(ChaptersTakenService service) {
        this.service = service;
    }

    @GetMapping
    public List<ChaptersTaken> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ChaptersTaken getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChaptersTaken create(@RequestBody ChaptersTaken entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public ChaptersTaken update(@PathVariable Long id, @RequestBody ChaptersTaken entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}