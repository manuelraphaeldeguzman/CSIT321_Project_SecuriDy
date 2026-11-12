package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.Course;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() { return repository.findAll(); }

    public Course getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found: " + id));
    }

    public Course create(Course course) {
        course.setCourseId(null);
        course.setCreatedAt(null);
        return repository.save(course);
    }

    public Course update(Long id, Course input) {
        Course existing = getById(id);
        existing.setCourseName(input.getCourseName());
        existing.setDescription(input.getDescription());
        existing.setSubject(input.getSubject());
        existing.setCreatedBy(input.getCreatedBy());
        return repository.save(existing);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
