package com.example.Schedule.repository;

import com.example.Schedule.model.Note;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository  extends JpaRepository<Note, Long> {
}
