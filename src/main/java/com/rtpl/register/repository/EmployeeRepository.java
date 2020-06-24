package com.rtpl.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rtpl.register.model.EmployeeRegister;

public interface EmployeeRepository extends JpaRepository<EmployeeRegister,Integer> {

}
