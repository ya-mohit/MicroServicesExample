package com.mohit.ms.microServicesExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.ms.microServicesExample.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/{id}")
	public Object fetchUserById(@PathVariable("id") int id) {
		return empService.fetchUsers(id);
	}
}
