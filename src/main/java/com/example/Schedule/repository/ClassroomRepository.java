package com.example.Schedule.repository;

import com.example.Schedule.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository  extends JpaRepository<Classroom, Long> {
}
