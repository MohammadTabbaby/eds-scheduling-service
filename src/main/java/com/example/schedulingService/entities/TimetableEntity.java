package com.example.schedulingService.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TimetableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long classId;
    private Long roomId;
    private Long subjectId;
    private Long professorId;

    @ElementCollection
    @CollectionTable(name = "timetable_timeslots", joinColumns = @JoinColumn(name = "timetable_id"))
    private Set<TimeSlot> timeSlots;

    // Constructors, getters, and setters

    public TimetableEntity() {
    }

    public TimetableEntity(Long classId, Long roomId, Long subjectId, Long professorId, Set<TimeSlot> timeSlots) {
        this.classId = classId;
        this.roomId = roomId;
        this.subjectId = subjectId;
        this.professorId = professorId;
        this.timeSlots = timeSlots;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Set<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(Set<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
