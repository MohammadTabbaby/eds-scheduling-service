package com.example.schedulingService.repositories;

import com.example.schedulingService.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
