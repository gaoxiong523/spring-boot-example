package com.gaoxiong.springboot.controller;

import com.gaoxiong.springboot.dao.EmployeeRepository;
import com.gaoxiong.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName EmpController
 * @Description TODO
 * @date 2018/9/24 17:15
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeRepository employeeRepository;


    /**
     * 查询所有员工返回列表页面
     * @param model
     */
    @GetMapping(value = "/emps")
    public String emps( Model model ) {
        List<Employee> emps = employeeRepository.findAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage () {
        //跳到添加页面
        return "emp/add";
    }

    @PostMapping("/emp")
    public String add (  Employee employee ) {
//        employee.setId(10001);
        Employee save = employeeRepository.save(employee);

        return "redirect:/emps";
    }
}
