package com.rtpl.register.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rtpl.register.common.RegisterConstants;
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

	@PostMapping(path = "/employee", produces = "applicaion/json")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeRegister employeeRegobj) {
		employeeService.upsertEmployee(employeeRegobj);

		JSONObject entity = new JSONObject();
		entity.put("message", "insert successful");

		return ResponseEntity.ok(entity.toString());
	}

	@PostMapping("/employees")
	public List<EmployeeRegister> addEmployees(@RequestBody List<EmployeeRegister> employeeRegobjs) {
		return employeeService.saveEmployees(employeeRegobjs);
	}

	@PutMapping("/employee")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRegister employeeupdateobj) {
		employeeService.upsertEmployee(employeeupdateobj);
		JSONObject entity = new JSONObject();
		entity.put("message", "Update successful");

		return ResponseEntity.ok(entity.toString());
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	@PostMapping(path = "/login", produces = "applicaion/json")
	public ResponseEntity<String> login(@RequestBody EmployeeRegister user) {

		JSONObject entity = new JSONObject();
		if (user.getEmail().equals("")) {
			entity.put("message", RegisterConstants.INVALID_EMAIL);
			// return ResponseEntity.badRequest().body(entity.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity.toString());
		}
		EmployeeRegister res;
		try {
			res = employeeService.getEmployeeByEmail(user.getEmail());
			if (!user.getPassword().equals(res.getPassword())) {
				entity.put("message", RegisterConstants.WRONG_PASSWORD);
				// return ResponseEntity.badRequest().body(entity.toString());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity.toString());
			}
		} catch (Exception e) {

			
			 if (e.getMessage().equals(RegisterConstants.USER_NOT_FOUND)) {
			  entity.put("message", RegisterConstants.USER_NOT_FOUND); return
			  ResponseEntity.status(HttpStatus.NOT_FOUND).body(entity.toString()); }
			 
		}

		entity.put("message", "login successful");
		return ResponseEntity.ok(entity.toString());

	}
}
