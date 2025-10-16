package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Teacher.java
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id", unique = true) private Integer userId;
    @Column(name = "faculty_id") private Integer facultyId;
    private String title;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @OneToMany(mappedBy = "newTeacher") private List<ScheduleOverride> scheduleOverrides = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "faculty_id", insertable = false, updatable = false)
    private Faculty faculty;
    @OneToMany(mappedBy = "teacher") private List<Schedule> schedule = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public Teacher() {}
    // getters/setters
}
