package com.example.demo.service;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    

    @Override
    public void save(Customer customer) {
         customerRepository.save(customer);
    }


    
}
