package com.example.Schedule.repository;

import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import main.java.com.example.Schedule.model.University;

public interface UniversityRepository  extends JpaRepository<University, Long> {
}
