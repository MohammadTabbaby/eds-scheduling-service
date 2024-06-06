package com.example.schedulingService.controllers;

import com.example.schedulingService.entities.ProfessorEntity;
import com.example.schedulingService.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorEntity> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @PostMapping
    public ProfessorEntity saveProfessor(@RequestBody ProfessorEntity professorEntity) {
        return professorService.saveProfessor(professorEntity);
    }
}
