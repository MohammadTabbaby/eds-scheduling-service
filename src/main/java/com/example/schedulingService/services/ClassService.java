package com.example.schedulingService.services;

import com.example.schedulingService.entities.ClassEntity;
import com.example.schedulingService.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }

    public ClassEntity saveClass(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }
}
