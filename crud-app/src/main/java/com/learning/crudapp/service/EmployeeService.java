package com.learning.crudapp.service;

import com.learning.crudapp.domain.Employee;
import com.learning.crudapp.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(EmployeeDTO employeeDTO);

    List<Employee> getEmployees();

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);

    Employee updateEmployee(int id, EmployeeDTO employeeDTO);
}
