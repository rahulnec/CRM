package com.rahul.crm.service;

import com.rahul.crm.Repository.EmployeeDAO;
import com.rahul.crm.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;


    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeDAO.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else
            throw new RuntimeException("Employee is not present with Id:" + id);

    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void delete(int employeeId) {
        employeeDAO.deleteById(employeeId);
    }
}
