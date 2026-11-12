package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.LessonAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonAttemptRepository
        extends JpaRepository<LessonAttempt, Long> {
}
