package com.gaoxiong.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gaoxiong.cache.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}