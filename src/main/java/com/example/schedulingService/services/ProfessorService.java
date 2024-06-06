package com.example.schedulingService.services;

import com.example.schedulingService.entities.ProfessorEntity;
import com.example.schedulingService.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorEntity> getAllProfessors() {
        return professorRepository.findAll();
    }

    public ProfessorEntity saveProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }
}
