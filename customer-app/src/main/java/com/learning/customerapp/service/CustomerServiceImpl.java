package com.learning.customerapp.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.learning.customerapp.dao.CustomerRepository;
import com.learning.customerapp.domain.Customer;
import com.learning.customerapp.dto.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO getCustomer(Integer customerId) {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> {throw new RuntimeException();});
        BeanUtils.copyProperties(customer, customerDTO);
        customerDTO.setCustomerId(customer.getId());
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        customers.forEach(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customer,customerDTO);
            customerDTOList.add(customerDTO);
        });
        return customerDTOList;
    }

    @Override
    public Integer addCustomer(CustomerDTO customer) {
        Customer customer1 = new Customer();
        BeanUtils.copyProperties(customer,customer1);
        return customerRepository.save(customer1).getId();
    }

    @Override
    public void updateCustomer(Integer customerId, String emailId) {

    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
