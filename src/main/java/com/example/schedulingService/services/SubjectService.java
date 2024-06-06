package com.example.schedulingService.services;

import com.example.schedulingService.entities.SubjectEntity;
import com.example.schedulingService.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public SubjectEntity saveSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity getSubjectById(Long id) {
        Optional<SubjectEntity> subjectOptional = subjectRepository.findById(id);
        return subjectOptional.orElse(null);
    }
}
