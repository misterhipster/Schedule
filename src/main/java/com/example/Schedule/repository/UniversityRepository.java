package com.example.Schedule.repository;

import com.example.Schedule.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository  extends JpaRepository<University, Long> {
}
