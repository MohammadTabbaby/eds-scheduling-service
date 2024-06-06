package com.example.schedulingService.controllers;

import com.example.schedulingService.entities.SubjectEntity;
import com.example.schedulingService.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<SubjectEntity> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public SubjectEntity saveSubject(@RequestBody SubjectEntity subjectEntity) {
        return subjectService.saveSubject(subjectEntity);
    }
    @GetMapping("/{id}/name")
    public String getSubjectNameById(@PathVariable Long id) {
        // Retrieve subject name from the database using the provided ID
        SubjectEntity subjectEntity = subjectService.getSubjectById(id);
        return subjectEntity != null ? subjectEntity.getName() : null;
    }
}
