package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.QuizzesTaken;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.QuizzesTakenRepository;
import com.csit321g5.securidy.securidy.repository.UserRepository;
import com.csit321g5.securidy.securidy.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzesTakenService {

    private final QuizzesTakenRepository repository;
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    public QuizzesTakenService(
            QuizzesTakenRepository repository,
            UserRepository userRepository,
            QuizRepository quizRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
    }

    public List<QuizzesTaken> getAll() {
        return repository.findAll();
    }

    public QuizzesTaken getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Quiz taken not found: " + id));
    }

    private void validateUser(Long userId) {
        if (userId == null || !userRepository.existsById(userId)) {
            throw new BadRequestException(
                    "userId must reference an existing user.");
        }
    }

    private void validateQuiz(String quizId) {
        if (quizId == null || !quizRepository.existsById(quizId)) {
            throw new BadRequestException(
                    "quizId must reference an existing quiz.");
        }
    }

    public QuizzesTaken create(QuizzesTaken quizzesTaken) {
        validateUser(quizzesTaken.getUserId());
        validateQuiz(quizzesTaken.getQuizId());

        quizzesTaken.setQuizzesTakenId(null);
        quizzesTaken.setStartedAt(null);
        quizzesTaken.setEndedAt(null);

        return repository.save(quizzesTaken);
    }

    public QuizzesTaken update(Long id, QuizzesTaken input) {
        QuizzesTaken existing = getById(id);

        validateUser(input.getUserId());
        validateQuiz(input.getQuizId());

        existing.setUserId(input.getUserId());
        existing.setQuizId(input.getQuizId());
        existing.setStatus(input.getStatus());
        existing.setEndedAt(input.getEndedAt());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}