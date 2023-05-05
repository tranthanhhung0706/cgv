package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Bill;
import com.example.demo.model.Schedule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.ScheduleService;

@RequestMapping("/api")
@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/schedule")
    public ScheduleDTO getSchedule(@RequestParam("id") int id) {
        // Schedule schedule = scheduleRepository.findById(id).orElse(null);
        // ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);

        // List<Ticket> tickets = ticketRepository.findBySchedule(schedule);
        // List<String> seats = new ArrayList<>();

        // for (Ticket ticket : tickets) {
        // seats.add(ticket.getSeat().getName());
        // }
        // // Collections.sort(seats);
        // scheduleDTO.setSeats(seats);
        return scheduleService.findById(id);
    }

}
