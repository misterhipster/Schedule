package com.example.Schedule.repository;

import com.example.Schedule.model.Schedule;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository  extends JpaRepository<Schedule, Long> {
}
