package com.dailycodebuffer.employeeservice.controller;

import com.dailycodebuffer.employeeservice.model.Employee;
import com.dailycodebuffer.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("******** Employee add: {}", employee);
        return employeeRepository.add(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("******** Employee findAll: {}");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        LOGGER.info("******** Employee findById: {}",id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") long departmentId){
        LOGGER.info("******** Employee findByDepartment: departmentId={}",departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }
}
