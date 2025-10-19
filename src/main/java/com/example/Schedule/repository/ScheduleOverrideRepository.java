package com.example.Schedule.repository;

import com.example.Schedule.model.ScheduleOverride;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleOverrideRepository  extends JpaRepository<ScheduleOverride, Long> {
}
