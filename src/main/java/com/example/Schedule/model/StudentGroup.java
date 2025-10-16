package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// StudentGroup.java
@Entity
@Table(name = "student_groups")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "faculty_id") private Integer facultyId;
    @Column(nullable = false) private String name;
    @Column(name = "year_of_admission") private Integer yearOfAdmission;
    @Column(name = "current_course") private Integer currentCourse;
    private String specialization;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "faculty_id", insertable = false, updatable = false)
    private Faculty faculty;
    @OneToMany(mappedBy = "group") private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "group") private List<ScheduleGroup> scheduleGroups = new ArrayList<>();
    @OneToMany(mappedBy = "targetGroup") private List<Note> groupNotes = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public StudentGroup() {}
    // getters/setters
}
