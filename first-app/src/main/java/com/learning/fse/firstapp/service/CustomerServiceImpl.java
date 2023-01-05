package com.learning.fse.firstapp.service;

import com.learning.fse.firstapp.dto.Customer;
import com.learning.fse.firstapp.dto.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    Customers customers = new Customers();
    @Override
    public Customer addCustomer(Customer customer) {
        customers.getCustomerList().add(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customers.getCustomerList();
    }
}
