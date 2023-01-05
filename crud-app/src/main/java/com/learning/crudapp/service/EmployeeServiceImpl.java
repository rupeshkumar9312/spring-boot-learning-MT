package com.learning.crudapp.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.learning.crudapp.dao.EmployeeRepository;
import com.learning.crudapp.domain.Employee;
import com.learning.crudapp.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(new Employee());
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee dbEmployee = employeeRepository.findById(id).get();
        dbEmployee.setFirstName(employeeDTO.getFirstName());
        dbEmployee.setAddress(employeeDTO.getAddress());
        dbEmployee.setSalary(employeeDTO.getSalary());
        dbEmployee.setLastName(employeeDTO.getLastName());
        dbEmployee.setDepartment(employeeDTO.getDepartment());
        return employeeRepository.save(dbEmployee);
    }


}
