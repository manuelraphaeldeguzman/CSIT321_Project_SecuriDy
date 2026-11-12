package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.LessonAttempt;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.LessonAttemptRepository;
import com.csit321g5.securidy.securidy.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonAttemptService {

    private final LessonAttemptRepository repository;
    private final LessonRepository lessonRepository;

    public LessonAttemptService(
            LessonAttemptRepository repository,
            LessonRepository lessonRepository) {
        this.repository = repository;
        this.lessonRepository = lessonRepository;
    }

    public List<LessonAttempt> getAll() {
        return repository.findAll();
    }

    public LessonAttempt getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lesson attempt not found: " + id));
    }

    private void validateLesson(Long lessonId) {
        if (lessonId == null || !lessonRepository.existsById(lessonId)) {
            throw new BadRequestException(
                    "lessonId must reference an existing lesson.");
        }
    }

    public LessonAttempt create(LessonAttempt attempt) {
        validateLesson(attempt.getLessonId());
        attempt.setAttemptId(null);
        return repository.save(attempt);
    }

    public LessonAttempt update(Long id, LessonAttempt input) {
        LessonAttempt existing = getById(id);
        validateLesson(input.getLessonId());

        existing.setLessonId(input.getLessonId());
        existing.setUserId(input.getUserId());
        existing.setScore(input.getScore());
        existing.setTimeSpent(input.getTimeSpent());
        existing.setCompletedAt(input.getCompletedAt());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
