package com.example.demo.service;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public CustomerDTO findCustomerByUserId(Integer userId) {
        // TODO Auto-generated method stub
        // customerRepository.findCustomerByUserId(userId);

        return modelMapper.map(customerRepository.findCustomerByUserId(userId), CustomerDTO.class);
    }

    public Customer getCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {

        return customerRepository.findAll().stream().map(
                customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());
    }


    public List<CustomerDTO> searchCustomers(String searchTerm) {
        List<Customer> customers = customerRepository.findBySearchTerm(searchTerm);
        return customers.stream().map(
                customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());
    }

    

    @Override
    public Page<Customer> getAllCustomersByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Customer> pageCustomer = customerRepository.findAll(pageable);
        return pageCustomer;
    }
    @Override
    public Page<Customer> getAllCustomersByPageSearch(int pageNumber, int pageSize,String searchTerm) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        // List<Customer> customers = customerRepository.findBySearchTerm(searchTerm);
        // int start = Math.toIntExact(pageable.getOffset());
        // int end = Math.min((start + pageable.getPageSize()), customers.size());
        // List<Customer> sublist = customers.subList(start, end);

        Page<Customer> pageCustomer = customerRepository.findBySearchTerm(searchTerm, pageable);
        return pageCustomer;
    }

    // public void updateCustomer(CustomerDTO customerDTO) {
    //     Optional<Customer> customer = customerRepository.findById(customerDTO.getId());
    //     if (customer.isPresent()) {
    //         Customer existingCustomer = customer.get();
    //         Customer s = customerConvert.toEntity2(customerDTO, existingCustomer);
    //         customerRepository.save(s);
    //     } else {
    //         throw new NotFoundException("Customer not found with ID: " + customerDTO.getId());
    //     }
    // }

}
