package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.ChaptersTaken;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.ChaptersTakenRepository;
import com.csit321g5.securidy.securidy.repository.UserRepository;
import com.csit321g5.securidy.securidy.repository.ChapterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChaptersTakenService {

    private final ChaptersTakenRepository repository;
    private final UserRepository userRepository;
    private final ChapterRepository chapterRepository;

    public ChaptersTakenService(
            ChaptersTakenRepository repository,
            UserRepository userRepository,
            ChapterRepository chapterRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.chapterRepository = chapterRepository;
    }

    public List<ChaptersTaken> getAll() {
        return repository.findAll();
    }

    public ChaptersTaken getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Chapter taken not found: " + id));
    }

    private void validateUser(String userId) {
        if (userId == null || !userRepository.existsById(userId)) {
            throw new BadRequestException(
                    "userId must reference an existing user.");
        }
    }

    private void validateChapter(Long chapterId) {
        if (chapterId == null || !chapterRepository.existsById(chapterId)) {
            throw new BadRequestException(
                    "chapterId must reference an existing chapter.");
        }
    }

    public ChaptersTaken create(ChaptersTaken chaptersTaken) {
        validateUser(chaptersTaken.getUserId());
        validateChapter(chaptersTaken.getChapterId());

        chaptersTaken.setChaptersTakenId(null);
        chaptersTaken.setStartedAt(null);

        return repository.save(chaptersTaken);
    }

    public ChaptersTaken update(Long id, ChaptersTaken input) {
        ChaptersTaken existing = getById(id);

        validateUser(input.getUserId());
        validateChapter(input.getChapterId());

        existing.setUserId(input.getUserId());
        existing.setChapterId(input.getChapterId());
        existing.setStatus(input.getStatus());
        existing.setCompletedAt(input.getCompletedAt());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}