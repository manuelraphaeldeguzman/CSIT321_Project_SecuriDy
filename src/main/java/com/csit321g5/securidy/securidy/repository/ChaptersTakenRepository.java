package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.ChaptersTaken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersTakenRepository
        extends JpaRepository<ChaptersTaken, Long> {

}