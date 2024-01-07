package com.example.EmployeeProject.dao;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee delete(int id);

    List<Employee> findByName(String name);

    Employee findByPhoneNumber(String phoneNumber);

}
