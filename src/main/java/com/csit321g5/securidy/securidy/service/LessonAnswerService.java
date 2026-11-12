package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.LessonAnswer;
import com.csit321g5.securidy.securidy.entity.LessonAttempt;
import com.csit321g5.securidy.securidy.entity.LessonQuestion;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.LessonAnswerRepository;
import com.csit321g5.securidy.securidy.repository.LessonAttemptRepository;
import com.csit321g5.securidy.securidy.repository.LessonQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonAnswerService {

    private final LessonAnswerRepository repository;
    private final LessonAttemptRepository attemptRepository;
    private final LessonQuestionRepository questionRepository;

    public LessonAnswerService(
            LessonAnswerRepository repository,
            LessonAttemptRepository attemptRepository,
            LessonQuestionRepository questionRepository) {
        this.repository = repository;
        this.attemptRepository = attemptRepository;
        this.questionRepository = questionRepository;
    }

    public List<LessonAnswer> getAll() {
        return repository.findAll();
    }

    public LessonAnswer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lesson answer not found: " + id));
    }

    private void validateReferences(Long attemptId, Long questionId) {
        if (attemptId == null) {
            throw new BadRequestException("attemptId is required.");
        }

        if (questionId == null) {
            throw new BadRequestException("questionId is required.");
        }

        LessonAttempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lesson attempt not found: " + attemptId));

        LessonQuestion question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lesson question not found: " + questionId));

        if (!attempt.getLessonId().equals(question.getLessonId())) {
            throw new BadRequestException(
                    "The question does not belong to the lesson in this attempt.");
        }
    }

    public LessonAnswer create(LessonAnswer answer) {
        validateReferences(answer.getAttemptId(), answer.getQuestionId());
        answer.setAnswerId(null);
        return repository.save(answer);
    }

    public LessonAnswer update(Long id, LessonAnswer input) {
        LessonAnswer existing = getById(id);

        validateReferences(input.getAttemptId(), input.getQuestionId());

        existing.setAttemptId(input.getAttemptId());
        existing.setQuestionId(input.getQuestionId());
        existing.setSelectedAnswer(input.getSelectedAnswer());
        existing.setIsCorrect(input.getIsCorrect());
        existing.setPoints(input.getPoints());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
