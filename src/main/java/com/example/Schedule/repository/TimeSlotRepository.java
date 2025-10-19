package com.example.Schedule.repository;

import com.example.Schedule.model.TimeSlot;
import com.example.Schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository  extends JpaRepository<TimeSlot, Long> {
}
