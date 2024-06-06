package com.example.schedulingService.controllers;

import com.example.schedulingService.entities.ClassEntity;
import com.example.schedulingService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassEntity> getAllClasses() {
        return classService.getAllClasses();
    }

    @PostMapping
    public ClassEntity saveClass(@RequestBody ClassEntity classEntity) {
        return classService.saveClass(classEntity);
    }
}
