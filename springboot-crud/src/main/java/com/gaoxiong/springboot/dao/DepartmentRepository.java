package com.gaoxiong.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gaoxiong.springboot.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}