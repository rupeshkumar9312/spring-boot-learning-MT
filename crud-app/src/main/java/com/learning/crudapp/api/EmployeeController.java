package com.learning.crudapp.api;

import com.learning.crudapp.domain.Employee;
import com.learning.crudapp.dto.EmployeeDTO;
import com.learning.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);

    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id,employeeDTO);
    }
}
