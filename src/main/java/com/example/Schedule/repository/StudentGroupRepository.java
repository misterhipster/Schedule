package com.example.Schedule.repository;

import com.example.Schedule.model.StudentGroup;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupRepository  extends JpaRepository<StudentGroup, Long> {
}
