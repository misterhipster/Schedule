package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// TimeSlot.java
@Entity
@Table(name = "time_slots")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "university_id") private Integer universityId;
    @Column(name = "slot_number") private Integer slotNumber;
    @Column(name = "start_time") private String startTime;
    @Column(name = "end_time") private String endTime;
    @Column(name = "is_active") private Boolean isActive = true;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "university_id", insertable = false, updatable = false)
    private University university;
    @OneToMany(mappedBy = "timeSlot") private List<Schedule> schedule = new ArrayList<>();
    @OneToMany(mappedBy = "newTimeSlot") private List<ScheduleOverride> scheduleOverrides = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public TimeSlot() {}
    // getters/setters
}
