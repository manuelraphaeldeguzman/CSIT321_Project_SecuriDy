package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.Enrollment;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.EnrollmentRepository;
import com.csit321g5.securidy.securidy.repository.UserRepository;
import com.csit321g5.securidy.securidy.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository repository, UserRepository userRepository,
                             CourseRepository courseRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public List<Enrollment> getAll() { return repository.findAll(); }

    public Enrollment getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enrollment not found: " + id));
    }

    private void validateReferences(Enrollment enrollment) {
        if (enrollment.getUserId() == null || !userRepository.existsById(enrollment.getUserId()))
            throw new BadRequestException("userId must reference an existing user.");
        if (enrollment.getCourseId() == null || !courseRepository.existsById(enrollment.getCourseId()))
            throw new BadRequestException("courseId must reference an existing course.");
    }

    public Enrollment create(Enrollment enrollment) {
        validateReferences(enrollment);
        enrollment.setEnrollmentId(null);
        enrollment.setDateEnrolled(null);
        return repository.save(enrollment);
    }

    public Enrollment update(Long id, Enrollment input) {
        Enrollment existing = getById(id);
        validateReferences(input);
        existing.setUserId(input.getUserId());
        existing.setCourseId(input.getCourseId());
        existing.setStatus(input.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
