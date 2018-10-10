package com.gaoxiong.cache.service;

import com.gaoxiong.cache.entity.Employee;
import com.gaoxiong.cache.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName EmployeeService
 * @Description TODO
 * @date 2018/10/11 0:00
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmpById(Integer id) {
        Employee emp = employeeRepository.getOne(id);
        return emp;
    }
}
