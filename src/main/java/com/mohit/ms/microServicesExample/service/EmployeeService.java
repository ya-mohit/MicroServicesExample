package com.mohit.ms.microServicesExample.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.ms.microServicesExample.entity.EmployeeEntity;
import com.mohit.ms.microServicesExample.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	ModelMapper mapper;
	
	public EmployeeEntity fetchUsers(int id){
		
		Optional<EmployeeEntity> entity = empRepo.findById(id);	
		EmployeeEntity emp = mapper.map(entity, EmployeeEntity.class);
		return emp;	
	}
}
