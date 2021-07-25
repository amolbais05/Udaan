package com.practice.application.springbootapp.repository;

import com.practice.application.springbootapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
