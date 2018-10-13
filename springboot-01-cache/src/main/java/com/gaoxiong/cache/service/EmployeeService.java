package com.gaoxiong.cache.service;

import com.gaoxiong.cache.entity.Employee;
import com.gaoxiong.cache.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName EmployeeService
 * @Description TODO
 * @date 2018/10/11 0:00
 */
@Service
@CacheConfig(cacheNames = "emp",cacheManager = "cacheManager")
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 讲方法的运行结果进行缓存:以后再要相同的数据,直接从缓存中获取,不用调用方法;
     * cachemanager管理多个cache组件的, 对缓存的真正CRUD操作在cache组件中,
     * 每一个缓存组件有自己唯一一个名字
     *      cacheName/value,指定缓存组件的名字
     *      key: 缓存数据使用的key ,默认使用方法参数的值
     *      编写 spEL:#id,#a0,#p0,#root.args[0]
     *      keyGenerator: key的生成器, 可以自己指定key 的生成器的组件id ,交给spring管理
     *      key和keyGenerator 二选一
     *      cacheManager:指定缓存管理器,或者cacheResolver 指定缓存解析器
     *      condition: 指定符合条件的情况下才缓存
     *      unless: 否定缓存,当unless满足条件,不缓存,可以获取到的结果进行判断,#result
     *      sync :是否使用异步模式 ,异步模式下, unless 不支持
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmpById(Integer id) {
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeRepository.getOne(id);
        return emp;
    }

    /**
     * cacheput:既调用方法,又更新缓存数据;
     * 修改了数据库的某个数据,同时更新缓存
     *  先调用目标方法,然后将目标方法的结果缓存起来
     */
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee) {
        Employee save = employeeRepository.save(employee);
        return save;
    }

    /**
     * cacheEvict: 缓存清楚
     * allEntries :当前cache组件中的所有缓存
     * beforeInvocation  缓存的清楚是否在方法之前执行 ,默认实在方法之后执行
     */
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){
        employeeRepository.deleteById(id);
    }

    @Caching(
            cacheable = {@Cacheable(value = "emp",key = "#lastName")},
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            },
            evict = {@CacheEvict(value = "emp",key = "#result.id")}
    )
    public Employee getEmpByLastName(String lastName) {
        Employee employee = employeeRepository.getOneByLastName(lastName);
        return employee;
    }
}
