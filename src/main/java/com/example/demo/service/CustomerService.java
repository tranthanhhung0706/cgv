package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Customer;
import com.example.demo.dto.CustomerDTO;

public interface CustomerService  {
   CustomerDTO findCustomerByUserId(Integer userId);

   void save(Customer customer);

    Customer getCustomerById(Integer id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    List<CustomerDTO> getAllCustomer();

    List<CustomerDTO> searchCustomers(String searchTerm);

    Page<Customer> getAllCustomersByPage(int pageNumber, int pageSize);

    Page<Customer> getAllCustomersByPageSearch(int pageNumber, int pageSize,String searchTerm);
   
}
