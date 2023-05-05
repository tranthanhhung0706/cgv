package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoomDTO;
import com.example.demo.dto.ScheduleDTO;
import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Schedule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    TicketService ticketService;
    @Autowired
    RoomService roomService;

    @Override
    public List<ScheduleDTO> getAllSchedule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSchedule'");
    }

    @Override
    public ScheduleDTO findById(Integer id) {
        // TODO Auto-generated method stub
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);

        List<TicketDTO> tickets = ticketService.findBySchedule(schedule);
        scheduleDTO.setRoom(roomService.findById(id));
        List<String> seats = new ArrayList<>();

        for (TicketDTO ticket : ticketService.findBySchedule(schedule)) {
            seats.add(ticket.getSeatName());
        }
        // Collections.sort(seats);
        scheduleDTO.setSeats(seats);
        return scheduleDTO;
    }

}
