package com.example.demo.service;


import java.util.List;
import com.example.demo.model.Customer;
import com.example.demo.dto.CustomerDTO;

public interface CustomerService  {
   // List<CustomerDTO> getCustomerByUserId(Integer userId);
   void save(Customer customer);
}
