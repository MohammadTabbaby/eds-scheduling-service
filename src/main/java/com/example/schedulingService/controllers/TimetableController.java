package com.example.schedulingService.controllers;

import com.example.schedulingService.entities.TimetableEntity;
import com.example.schedulingService.services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/timetables")
public class TimetableController {
    @Autowired
    private TimetableService timetableService;

    @GetMapping
    public List<TimetableEntity> getAllTimetables() {
        return timetableService.getAllTimetables();
    }

    @PostMapping
    public ResponseEntity<TimetableEntity> createTimetable(@RequestBody TimetableEntity timetableEntity) {
        TimetableEntity savedTimetable = timetableService.createTimetable(timetableEntity);
        return ResponseEntity.status(201).body(savedTimetable);
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<TimetableEntity>> getTimetablesByClass(@PathVariable Long classId) {
        List<TimetableEntity> timetables = timetableService.getTimetablesByClass(classId);
        return ResponseEntity.ok(timetables);
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<TimetableEntity>> getTimetablesByProfessor(@PathVariable Long professorId) {
        List<TimetableEntity> timetables = timetableService.getTimetablesByProfessor(professorId);
        return ResponseEntity.ok(timetables);
    }
}
