package com.learning.customerapp.api;

import com.learning.customerapp.dto.CustomerDTO;
import com.learning.customerapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) {

        CustomerDTO customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PostMapping(value = "/customers")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customer) {
        Integer customerId = customerService.addCustomer(customer);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer) {
        //TODO: to be implemented in service layer
        customerService.updateCustomer(customerId, customer.getEmailId());
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}
