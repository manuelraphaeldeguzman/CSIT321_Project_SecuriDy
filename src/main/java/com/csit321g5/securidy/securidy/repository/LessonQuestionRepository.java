package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.LessonQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonQuestionRepository
        extends JpaRepository<LessonQuestion, String> {
}
