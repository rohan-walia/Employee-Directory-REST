package com.example.EmployeeProject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Employee delete(int id) {
        Employee employee = findById(id);
        entityManager.remove(employee);

        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee where firstName= :firstName", Employee.class);
        query.setParameter("firstName", name);

        return query.getResultList();
    }

    @Override
    public Employee findByPhoneNumber(String phoneNumber) {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee where phoneNumber = :phoneNumber", Employee.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getSingleResult();
    }
}
