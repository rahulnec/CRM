package com.rahul.crm.service;

import com.rahul.crm.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(int id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void delete(int employeeId);




}
