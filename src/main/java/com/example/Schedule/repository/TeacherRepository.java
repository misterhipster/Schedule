package com.example.Schedule.repository;

import com.example.Schedule.model.Teacher;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
}
