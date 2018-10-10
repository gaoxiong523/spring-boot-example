package com.gaoxiong.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gaoxiong.cache.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}