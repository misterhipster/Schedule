package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Faculty.java
@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "university_id") private Integer universityId;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String code;
    @Column(name = "dean_name") private String deanName;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "university_id", insertable = false, updatable = false)
    private main.java.com.example.Schedule.model.University university;
    @OneToMany(mappedBy = "faculty") private List<StudentGroup> studentGroups = new ArrayList<>();
    @OneToMany(mappedBy = "faculty") private List<Subject> subjects = new ArrayList<>();
    @OneToMany(mappedBy = "faculty") private List<Teacher> teachers = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public Faculty() {}
    // getters/setters
}
