package com.gaoxiong.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gaoxiong.cache.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Override
    void deleteById ( Integer id );

    Employee getOneByLastName (String lastName);

    /**
     * 根据邮箱和lastName 以什么结束来查
     * @param email
     * @param lastNameEndingWith
     * @return
     */
    Employee getEmployeeByEmailAndLastNameEndingWith(String email,String lastNameEndingWith);
}