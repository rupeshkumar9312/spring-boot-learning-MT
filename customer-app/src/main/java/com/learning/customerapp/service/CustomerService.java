package com.learning.customerapp.service;


import com.learning.customerapp.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
	CustomerDTO getCustomer(Integer customerId);
	List<CustomerDTO> getAllCustomers();
	Integer addCustomer(CustomerDTO customer);
	void updateCustomer(Integer customerId, String emailId);
	void deleteCustomer(Integer customerId);
}
