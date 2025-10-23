package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Building.java
@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "university_id") private Integer universityId;
    @Column(name = "building_number", nullable = false) private String buildingNumber;
    private String name; private String address;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "university_id", insertable = false, updatable = false)
    private University university;
    @OneToMany(mappedBy = "building") private List<Classroom> classrooms = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public Building() {}
    // getters/setters
}
