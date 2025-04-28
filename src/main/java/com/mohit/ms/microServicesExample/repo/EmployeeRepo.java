package com.mohit.ms.microServicesExample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.ms.microServicesExample.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{

}
