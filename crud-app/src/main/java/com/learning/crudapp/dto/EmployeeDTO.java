package com.learning.crudapp.dto;

public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String department;
    private String address;
    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String firstName, String lastName, String department, String address, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.address = address;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
