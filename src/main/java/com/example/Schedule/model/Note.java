package com.example.Schedule.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import com.example.Schedule.model.enums.*;

// Note.java
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id") private Integer userId;
    private String title;
    @Column(nullable = false) private String content;
    @Enumerated(EnumType.STRING) private Priority priority = Priority.MEDIUM;
    @Enumerated(EnumType.STRING) @Column(name = "scope_type") private NoteScope scopeType;
    @Column(name = "schedule_id") private Integer scheduleId;
    @Column(name = "subject_id") private Integer subjectId;
    @Column(name = "target_group_id") private Integer targetGroupId;
    @Column(name = "target_date") private LocalDateTime targetDate;
    @Column(name = "target_week") private Integer targetWeek;
    @Column(name = "academic_year") private String academicYear;
    private Integer semester;
    private String attachments;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "updated_at") private LocalDateTime updatedAt;
    @Column(name = "is_offline") private Boolean isOffline = false;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "target_group_id", insertable = false, updatable = false)
    private StudentGroup targetGroup;
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now(); }
    @PreUpdate protected void onUpdate() { updatedAt = LocalDateTime.now(); }
    public Note() {}
    // getters/setters
}
