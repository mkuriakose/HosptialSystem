package com.example.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hospital.model.Nurse;
import com.example.Hospital.repository.NurseRepository;

@Service
public class NurseService {
	@Autowired
	private NurseRepository nurseRepository;
	 
	public List<Nurse> listAll(){
		 return nurseRepository.findAll();
	}
	
	public void save(Nurse nurse) {
		nurseRepository.save(nurse);
	}
	
	public Nurse get(long id) {
		return nurseRepository.getById(id);
	}
	
	public void delete(long id) {
		nurseRepository.deleteById(id);
	}
	
}
