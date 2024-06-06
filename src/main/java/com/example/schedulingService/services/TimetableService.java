package com.example.schedulingService.services;

import com.example.schedulingService.entities.TimetableEntity;
import com.example.schedulingService.repositories.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    public List<TimetableEntity> getAllTimetables() {
        return timetableRepository.findAll();
    }

    public TimetableEntity createTimetable(TimetableEntity timetableEntity) {
        return timetableRepository.save(timetableEntity);
    }

    public List<TimetableEntity> getTimetablesByClass(Long classId) {
        return timetableRepository.findByClassId(classId);
    }

    public List<TimetableEntity> getTimetablesByProfessor(Long professorId) {
        return timetableRepository.findByProfessorId(professorId);
    }
}
