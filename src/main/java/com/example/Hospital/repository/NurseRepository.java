package com.example.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hospital.model.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Long>{

}
