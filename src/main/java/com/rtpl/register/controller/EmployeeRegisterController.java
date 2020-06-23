package com.rtpl.register.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	/*
	 * //Get All Notes
	 * 
	 * @GetMapping("/register") public List<EmployeeRegister> getAllEmployee() {
	 * return employeeRepositoryobj.findAll(); }
	 * 
	 * 
	 * 
	 * //Create a new Note
	 * 
	 * @PostMapping("/notes") public EmployeeRegister
	 * createEmployee(@Valid @RequestBody EmployeeRegister employeeRegister) {
	 * return employeeRepositoryobj.save(employeeRegister); }
	 * 
	 * 
	 * @RequestMapping("/notes/{id}") public EmployeeRegister
	 * createEmployee(@PathVariable String id){ return
	 * employeeRepositoryobj.save(employeeRegister);
	 * 
	 * 
	 * }
	 */
	//List 
    //it means you create a new instance	

	 @GetMapping("/employee")
	    public List<EmployeeRegister> findAllEmployees() {
	        return employeeService.getEmployees();
	    }

	    @GetMapping("/employeeById/{id}")
	    public EmployeeRegister findEmployeeById(@PathVariable int id) {
	        return employeeService.getEmployeeById(id);
	    }
	
	
	
	

	//Post 
	//PostMethod
	
	
	 @PostMapping("/addEmployee")
	    public EmployeeRegister addEmployee(@RequestBody EmployeeRegister employeeRegobj) {
	        return employeeService.saveEmployee(employeeRegobj);
	    }
	
	
	  @PostMapping("/addEmployees")
	    public List<EmployeeRegister> employeeRegobj(@RequestBody List<EmployeeRegister> employeeRegobjs) {
	        return employeeService.saveEmployees(employeeRegobjs);
	    }

	
	
	
}
