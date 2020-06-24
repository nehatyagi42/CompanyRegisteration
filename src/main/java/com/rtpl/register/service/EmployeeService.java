
package com.rtpl.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

import com.rtpl.register.model.EmployeeRegister;
import com.rtpl.register.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeRegister saveEmployee(EmployeeRegister employee) {
		return employeeRepository.save(employee);
	}

	public List<EmployeeRegister> saveEmployees(List<EmployeeRegister> employees) {
		return employeeRepository.saveAll(employees);
	}

	public List<EmployeeRegister> getEmployees() {
		return employeeRepository.findAll();
	}

	public EmployeeRegister getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

}
