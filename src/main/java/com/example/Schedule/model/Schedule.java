package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Schedule.java
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "subject_id") private Integer subjectId;
    @Column(name = "teacher_id") private Integer teacherId;
    @Column(name = "classroom_id") private Integer classroomId;
    @Column(name = "time_slot_id") private Integer timeSlotId;
    @Column(name = "day_of_week") private Integer dayOfWeek;
    @Enumerated(EnumType.STRING) @Column(name = "lesson_type") private main.java.com.example.Schedule.model.enums.LessonType lessonType;
    @Enumerated(EnumType.STRING) @Column(name = "week_type") private main.java.com.example.Schedule.model.enums.WeekType weekType = main.java.com.example.Schedule.model.enums.WeekType.ALL;
    @Column(name = "valid_weeks") private String validWeeks;
    @Column(name = "academic_year") private String academicYear;
    private Integer semester;
    @Column(name = "is_active") private Boolean isActive = true;
    private String notes;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "updated_at") private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "classroom_id", insertable = false, updatable = false)
    private Classroom classroom;
    @ManyToOne
    @JoinColumn(name = "time_slot_id", insertable = false, updatable = false)
    private TimeSlot timeSlot;
    @OneToMany(mappedBy = "schedule") private List<ScheduleGroup> scheduleGroups = new ArrayList<>();
    @OneToMany(mappedBy = "schedule") private List<ScheduleOverride> overrides = new ArrayList<>();
    @OneToMany(mappedBy = "schedule") private List<Note> userNotes = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now(); }
    @PreUpdate protected void onUpdate() { updatedAt = LocalDateTime.now(); }
    public Schedule() {}
    // getters/setters
}
