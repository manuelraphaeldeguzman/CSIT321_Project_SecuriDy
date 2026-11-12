package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.LessonQuestion;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.LessonQuestionRepository;
import com.csit321g5.securidy.securidy.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonQuestionService {

    private final LessonQuestionRepository repository;
    private final LessonRepository lessonRepository;

    public LessonQuestionService(
            LessonQuestionRepository repository,
            LessonRepository lessonRepository) {
        this.repository = repository;
        this.lessonRepository = lessonRepository;
    }

    public List<LessonQuestion> getAll() {
        return repository.findAll();
    }

    public List<LessonQuestion> getByLessonId(String lessonId) {
        if (!lessonRepository.existsById(lessonId)) {
            throw new ResourceNotFoundException("Lesson not found: " + lessonId);
        }

        return repository.findByLessonIdOrderByOrderNoAsc(lessonId);
    }

    public LessonQuestion getById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lesson question not found: " + id));
    }

    private void validateLesson(String lessonId) {
        if (lessonId == null || !lessonRepository.existsById(lessonId)) {
            throw new BadRequestException(
                    "lessonId must reference an existing lesson.");
        }
    }

    public LessonQuestion create(LessonQuestion question) {
        validateLesson(question.getLessonId());
        question.setQuestionId(null);
        return repository.save(question);
    }

    public LessonQuestion update(String id, LessonQuestion input) {
        LessonQuestion existing = getById(id);
        validateLesson(input.getLessonId());

        existing.setLessonId(input.getLessonId());
        existing.setQuestionText(input.getQuestionText());
        existing.setOption(input.getOption());
        existing.setCorrectAnswer(input.getCorrectAnswer());
        existing.setQuestionType(input.getQuestionType());
        existing.setPoints(input.getPoints());
        existing.setOrderNo(input.getOrderNo());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.delete(getById(id));
    }
}
