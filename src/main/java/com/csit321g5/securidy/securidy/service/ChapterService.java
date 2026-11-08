package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.Chapter;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.ChapterRepository;
import com.csit321g5.securidy.securidy.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {
    private final ChapterRepository repository;
    private final CourseRepository courseRepository;

    public ChapterService(ChapterRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    public List<Chapter> getAll() { return repository.findAll(); }

    public Chapter getById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chapter not found: " + id));
    }

    private void validateCourse(String courseId) {
        if (courseId == null || !courseRepository.existsById(courseId))
            throw new BadRequestException("courseId must reference an existing course.");
    }

    public Chapter create(Chapter chapter) {
        validateCourse(chapter.getCourseId());
        chapter.setChapterId(null);
        chapter.setCreatedAt(null);
        return repository.save(chapter);
    }

    public Chapter update(String id, Chapter input) {
        Chapter existing = getById(id);
        validateCourse(input.getCourseId());
        existing.setCourseId(input.getCourseId());
        existing.setTitle(input.getTitle());
        existing.setDescription(input.getDescription());
        existing.setOrderNo(input.getOrderNo());
        return repository.save(existing);
    }

    public void delete(String id) { repository.delete(getById(id)); }
}
