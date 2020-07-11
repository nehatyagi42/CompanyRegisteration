
package com.rtpl.register.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

import com.rtpl.register.common.RegisterConstants;
import com.rtpl.register.model.EmployeeRegister;
import com.rtpl.register.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeRegister upsertEmployee(EmployeeRegister employee) {
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


	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "employee removed successfully !!" + id;
	}

	public EmployeeRegister getEmployeeByEmail(String email) throws Exception{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployeeRegister> criteriaQuery = cb.createQuery(EmployeeRegister.class);
		Root<EmployeeRegister> root = criteriaQuery.from(EmployeeRegister.class);
		criteriaQuery.select(root).where(cb.equal(root.get("email"), email));

		TypedQuery<EmployeeRegister> query = em.createQuery(criteriaQuery);
		List<EmployeeRegister> employeelist = query.getResultList();
		if (employeelist.size() == 0) {
			 throw new Exception(RegisterConstants.USER_NOT_FOUND);
		}
		return employeelist.get(0);
	}

}
