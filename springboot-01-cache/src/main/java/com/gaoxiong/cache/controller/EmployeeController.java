package com.gaoxiong.cache.controller;

import com.gaoxiong.cache.entity.Employee;
import com.gaoxiong.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaoxiong
 * @ClassName EmployeeController
 * @Description TODO
 * @date 2018/10/11 0:04
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    @ResponseBody
    public Employee getById(@PathVariable Integer id) {
        return employeeService.getEmpById(id);
    }


}
