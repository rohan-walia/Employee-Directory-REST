package com.example.EmployeeProject.rest;

import com.example.EmployeeProject.dao.Employee;
import com.example.EmployeeProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee fetchEmployee(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employeeByName")
    public List<Employee> fetchEmployeeByName(@RequestBody Employee employee) {
        return employeeService.findByName(employee);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees")
    public Employee deleteEmployee(@PathVariable int id) {
        return employeeService.delete(id);
    }

    @GetMapping("/phone")
    public Employee searchPhoneNumber(@RequestBody Employee phoneNumber) {
        return employeeService.findByPhoneNumber(phoneNumber);
    }
}
