package com.example.Schedule.model;

import jakarta.persistence.*;

// ScheduleGroup.java
@Entity
@Table(name = "schedule_groups")
public class ScheduleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "schedule_id") private Integer scheduleId;
    @Column(name = "group_id") private Integer groupId;
    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private StudentGroup group;
    public ScheduleGroup() {}
    // getters/setters
}
