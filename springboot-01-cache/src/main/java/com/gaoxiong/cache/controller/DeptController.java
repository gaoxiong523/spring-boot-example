package com.gaoxiong.cache.controller;

import com.gaoxiong.cache.entity.Department;
import com.gaoxiong.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong
 * @ClassName DeptController
 * @Description TODO
 * @date 2018/10/13 23:23
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/{id}")
    public Department getDeptById(@PathVariable Integer id){
        Department deptById = departmentService.getDeptById(id);
        return deptById;
    }
}
