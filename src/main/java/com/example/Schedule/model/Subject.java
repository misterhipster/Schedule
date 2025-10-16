package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Subject.java
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "faculty_id") private Integer facultyId;
    @Column(nullable = false) private String name;
    @Column(name = "short_name") private String shortName;
    @Column(name = "course_number") private Integer courseNumber;
    private Integer semester;
    private Integer credits = 0;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "faculty_id", insertable = false, updatable = false)
    private Faculty faculty;
    @OneToMany(mappedBy = "subject") private List<Schedule> schedule = new ArrayList<>();
    @OneToMany(mappedBy = "subject") private List<Note> notes = new ArrayList<>();
    @OneToMany(mappedBy = "newSubject") private List<ScheduleOverride> scheduleOverrides = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public Subject() {}
    // getters/setters
}
