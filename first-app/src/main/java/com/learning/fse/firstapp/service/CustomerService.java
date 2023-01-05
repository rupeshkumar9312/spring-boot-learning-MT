package com.learning.fse.firstapp.service;

import com.learning.fse.firstapp.dto.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomer();
}
