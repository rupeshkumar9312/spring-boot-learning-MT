package com.learning.fse.firstapp.api;

import com.learning.fse.firstapp.dto.Customer;
import com.learning.fse.firstapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WelcomeAPI {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/messages")
    public String getMessage(){
        return "Welcome to Restful web services";
    }

    @GetMapping("/date")
    public String getDate(){
        return new Date().toString();
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
