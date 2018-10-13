package com.gaoxiong.cache.service;

import com.gaoxiong.cache.entity.Department;
import com.gaoxiong.cache.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName DepartmentService
 * @Description TODO
 * @date 2018/10/13 23:20
 */
@Service
@CacheConfig(cacheNames = "dept",cacheManager = "cacheManager")
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    @Cacheable
    public Department getDeptById(Integer id){
        log.info("查询部门编号为:"+id+"的部门");
        return departmentRepository.getOne(id);
    }
}
