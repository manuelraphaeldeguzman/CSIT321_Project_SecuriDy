package com.csit321g5.securidy.securidy.controller;

import com.csit321g5.securidy.securidy.entity.Chapter;
import com.csit321g5.securidy.securidy.service.ChapterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@CrossOrigin(origins = "*")
public class ChapterController {
    private final ChapterService service;

    public ChapterController(ChapterService service) { this.service = service; }

    @GetMapping
    public List<Chapter> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Chapter getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chapter create(@RequestBody Chapter entity) { return service.create(entity); }

    @PutMapping("/{id}")
    public Chapter update(@PathVariable Long id, @RequestBody Chapter entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
