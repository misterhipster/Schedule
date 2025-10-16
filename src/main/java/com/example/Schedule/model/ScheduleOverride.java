package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// ScheduleOverride.java
@Entity
@Table(name = "schedule_overrides")
public class ScheduleOverride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "schedule_id") private Integer scheduleId;
    @Column(name = "week_numbers") private String weekNumbers;
    @Enumerated(EnumType.STRING) @Column(name = "change_type") private main.java.com.example.Schedule.model.enums.OverrideType changeType;
    @Column(name = "new_subject_id") private Integer newSubjectId;
    @Column(name = "new_teacher_id") private Integer newTeacherId;
    @Column(name = "new_classroom_id") private Integer newClassroomId;
    @Column(name = "new_time_slot_id") private Integer newTimeSlotId;
    @Enumerated(EnumType.STRING) @Column(name = "new_lesson_type") private main.java.com.example.Schedule.model.enums.LessonType newLessonType;
    @Column(name = "new_day_of_week") private Integer newDayOfWeek;
    private String reason;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "created_by") private Integer createdBy;
    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "new_subject_id", insertable = false, updatable = false)
    private Subject newSubject;
    @ManyToOne
    @JoinColumn(name = "new_teacher_id", insertable = false, updatable = false)
    private Teacher newTeacher;
    @ManyToOne
    @JoinColumn(name = "new_classroom_id", insertable = false, updatable = false)
    private Classroom newClassroom;
    @ManyToOne
    @JoinColumn(name = "new_time_slot_id", insertable = false, updatable = false)
    private TimeSlot newTimeSlot;
    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    private User creator;
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public ScheduleOverride() {}
    // getters/setters
}
