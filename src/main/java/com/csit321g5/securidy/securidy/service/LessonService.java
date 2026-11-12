package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.Lesson;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.ChapterRepository;
import com.csit321g5.securidy.securidy.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository repository;
    private final ChapterRepository chapterRepository;

    public LessonService(LessonRepository repository, ChapterRepository chapterRepository) {
        this.repository = repository;
        this.chapterRepository = chapterRepository;
    }

    public List<Lesson> getAll() {
        return repository.findAll();
    }

    public Lesson getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found: " + id));
    }

    private void validateChapter(String chapterId) {
        if (chapterId == null || !chapterRepository.existsById(chapterId)) {
            throw new BadRequestException("chapterId must reference an existing chapter.");
        }
    }

    public Lesson create(Lesson lesson) {
        validateChapter(lesson.getChapterId());
        lesson.setLessonId(null);
        lesson.setCreatedAt(null);
        return repository.save(lesson);
    }

    public Lesson update(String id, Lesson input) {
        Lesson existing = getById(id);
        validateChapter(input.getChapterId());

        existing.setChapterId(input.getChapterId());
        existing.setTitle(input.getTitle());
        existing.setContent(input.getContent());
        existing.setOrderNo(input.getOrderNo());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.delete(getById(id));
    }
}
