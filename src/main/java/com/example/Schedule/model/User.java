package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// User.java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "university_id") private Integer universityId;
    @Column(unique = true, nullable = false) private String email;
    @Column(name = "password_hash", nullable = false) private String passwordHash;
    @Column(name = "first_name", nullable = false) private String firstName;
    @Column(name = "last_name", nullable = false) private String lastName;
    @Column(name = "middle_name") private String middleName;
    @Enumerated(EnumType.STRING) private main.java.com.example.Schedule.model.enums.UserRole role;
    @Column(name = "is_active") private Boolean isActive = true;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "updated_at") private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "university_id", insertable = false, updatable = false)
    private main.java.com.example.Schedule.model.University university;
    @OneToOne(mappedBy = "user") private Teacher teacher;
    @OneToOne(mappedBy = "user") private Student student;
    @OneToMany(mappedBy = "user") private List<Note> notes = new ArrayList<>();
    @OneToMany(mappedBy = "creator") private List<ScheduleOverride> scheduleOverrides = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now(); }
    @PreUpdate protected void onUpdate() { updatedAt = LocalDateTime.now(); }
    public User() {}
    // getters/setters
}
