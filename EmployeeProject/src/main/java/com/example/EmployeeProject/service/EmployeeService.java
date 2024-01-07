package com.example.EmployeeProject.service;

import com.example.EmployeeProject.dao.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee delete(int id);

    List<Employee> findByName(Employee employee);

    Employee findByPhoneNumber(Employee phoneNumber);
}
