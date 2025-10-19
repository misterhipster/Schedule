package com.example.Schedule.repository;

import com.example.Schedule.model.Subject;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository  extends JpaRepository<Subject, Long> {
}
