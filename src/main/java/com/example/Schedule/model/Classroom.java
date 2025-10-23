package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.Schedule.model.enums.*;

// Classroom.java
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "building_id") private Integer buildingId;
    @Column(name = "room_number", unique = true) private String roomNumber;
    @Column(name = "floor_number") private Integer floorNumber;
    @Column(name = "room_suffix") private String roomSuffix;
    private Integer capacity = 0;
    @Enumerated(EnumType.STRING) @Column(name = "room_type") private RoomType roomType = RoomType.LECTURE;
    @Column(name = "has_projector") private Boolean hasProjector = false;
    @Column(name = "has_computers") private Boolean hasComputers = false;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;
    @OneToMany(mappedBy = "classroom") private List<Schedule> schedule = new ArrayList<>();
    @OneToMany(mappedBy = "newClassroom") private List<ScheduleOverride> scheduleOverrides = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    public Classroom() {}
    // getters/setters
}
