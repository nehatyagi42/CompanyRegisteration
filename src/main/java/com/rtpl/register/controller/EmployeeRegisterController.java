package com.rtpl.register.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rtpl.register.model.EmployeeRegister;
import com.rtpl.register.service.EmployeeService;

@RestController

public class EmployeeRegisterController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<EmployeeRegister> findAllEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employee/{id}")
	public EmployeeRegister findEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employee")
	public EmployeeRegister addEmployee(@RequestBody EmployeeRegister employeeRegobj) {
		
		return employeeService.saveEmployee(employeeRegobj);
	}
	
	@PostMapping("/employees")
	public List<EmployeeRegister> addEmployees(@RequestBody List<EmployeeRegister> employeeRegobjs) {
		return employeeService.saveEmployees(employeeRegobjs);
	}

}
