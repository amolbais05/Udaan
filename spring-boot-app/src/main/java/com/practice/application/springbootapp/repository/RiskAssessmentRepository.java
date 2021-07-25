package com.practice.application.springbootapp.repository;

import com.practice.application.springbootapp.domain.Person;
import com.practice.application.springbootapp.domain.RiskAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskAssessmentRepository extends JpaRepository<RiskAssessment,Long> {
}
