package com.example.schedulingService.repositories;

import com.example.schedulingService.entities.TimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<TimetableEntity, Long> {
    List<TimetableEntity> findByClassId(Long classId);
    List<TimetableEntity> findByProfessorId(Long professorId);
}
