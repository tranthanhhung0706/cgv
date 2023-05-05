package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bill;
import com.example.demo.model.Schedule;
import com.example.demo.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findBySchedule(Schedule schedule);

    List<Ticket> findByBill(Bill bill);

    // void saveAll(List<Ticket> tickets);
}
