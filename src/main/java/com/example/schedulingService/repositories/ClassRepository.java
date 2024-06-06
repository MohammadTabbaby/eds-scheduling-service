package com.example.schedulingService.repositories;

import com.example.schedulingService.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
