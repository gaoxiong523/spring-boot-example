package com.gaoxiong.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gaoxiong.springboot.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}