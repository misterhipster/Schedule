package com.example.Schedule.repository;

import com.example.Schedule.model.ScheduleGroup;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleGroupRepository  extends JpaRepository<ScheduleGroup, Long> {
}
