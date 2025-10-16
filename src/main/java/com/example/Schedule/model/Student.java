package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Student.java
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id", unique = true) private Integer userId;
    @Column(name = "group_id") private Integer groupId;
    @Column(name = "student_number", unique = true) private String studentNumber;
    @Column(name = "admission_year") private Integer admissionYear;
    @Column(name = "current_course") private Integer currentCourse;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private StudentGroup group;
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public Student() {}
    // getters/setters
}
