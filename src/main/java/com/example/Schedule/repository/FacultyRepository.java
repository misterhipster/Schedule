package com.example.Schedule.repository;

import com.example.Schedule.model.Faculty;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository  extends JpaRepository<Faculty, Long> {
}
