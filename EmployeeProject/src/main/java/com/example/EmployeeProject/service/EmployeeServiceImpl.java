package com.example.EmployeeProject.service;

import com.example.EmployeeProject.dao.Employee;
import com.example.EmployeeProject.dao.EmployeeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public Employee delete(int id) {
        return employeeDao.delete(id);
    }

    @Override
    public List<Employee> findByName(Employee employee) {
        List<Employee> employeeList = employeeDao.findByName(employee.getFirstName());
        return employeeList;
    }

    @Override
    public Employee findByPhoneNumber(Employee phoneNumber) {
        phoneNumber = employeeDao.findByPhoneNumber(phoneNumber.getPhoneNumber());
        return phoneNumber;
    }
}
