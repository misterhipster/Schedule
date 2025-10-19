package com.example.Schedule.repository;

import com.example.Schedule.model.Student;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
