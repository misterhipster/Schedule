package main.java.com.example.Schedule.model;

import com.example.Schedule.model.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false) private String name;
    @Column(unique = true, nullable = false) private String code;
    @Column(name = "time_zone") private String timeZone = "Europe/Moscow";
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "updated_at") private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "university") private List<Building> buildings = new ArrayList<>();
    @OneToMany(mappedBy = "university") private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "university") private List<Faculty> faculties = new ArrayList<>();
    @OneToMany(mappedBy = "university") private List<TimeSlot> timeSlots = new ArrayList<>();
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
    @PreUpdate protected void onUpdate() { updatedAt = LocalDateTime.now(); }
    public University() {}
    // getters/setters
}

