package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Bill;
import com.example.demo.model.Schedule;
import com.example.demo.model.Ticket;

public interface TicketService {
    List<TicketDTO> getAll();

    List<TicketDTO> findByBill(Bill bill);

    TicketDTO findById(Integer id);

    void save(TicketDTO ticketDTO);

    List<Ticket> saveAll(List<TicketDTO> ticketDTOs);

    void update(TicketDTO ticketDTO);

    void delete(TicketDTO ticket);

    List<TicketDTO> findBySchedule(Schedule schedule);
}
