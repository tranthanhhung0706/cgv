package com.example.demo.repository;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //Customer findByName(String name);

    //@Query("SELECT t FROM Ticket t WHERE t.bill.id IN (SELECT b.id FROM Bill b WHERE b.user.id=:userId) ORDER BY t.id DESC")
    @Query("SELECT c FROM Customer c WHERE c.user.id=:userId ORDER BY c.id DESC")
    List<CustomerDTO> findCustomerByUserId(@Param("userId") Integer userId);

}