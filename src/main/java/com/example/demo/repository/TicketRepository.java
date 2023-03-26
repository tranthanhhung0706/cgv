package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ticket;



@Repository
public interface TicketRepository extends  JpaRepository<Ticket, Integer> {
    
}

