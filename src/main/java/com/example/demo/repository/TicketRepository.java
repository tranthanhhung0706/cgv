package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Bill;
import com.example.demo.model.Schedule;
import com.example.demo.model.Ticket;
import com.example.demo.model.User;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findBySchedule(Schedule schedule);

    List<Ticket> findByBill(Bill bill);

    // void saveAll(List<Ticket> tickets);

    @Query(value = "SELECT * from cinemaa.ticket t where t.bill_id in (select id from cinemaa.bill where cinemaa.bill.user_id = :user_id)", nativeQuery = true)
    List<Ticket> getAllByUser(@Param("user_id") Integer userID);
}
