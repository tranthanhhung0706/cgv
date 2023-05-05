package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.dto.ShowScheduleDTO;
import com.example.demo.dto.ShowTimeDTO;
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
    // @Autowired
    // private ScheduleService scheduleService;

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/schedule")
    public ScheduleDTO getSchedule(@RequestParam("id") int id) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);

        List<Ticket> tickets = ticketRepository.findBySchedule(schedule);
        List<String> seats = new ArrayList<>();

        for (Ticket ticket : tickets) {
            seats.add(ticket.getSeat().getName());
        }
        // Collections.sort(seats);
        scheduleDTO.setSeats(seats);
        return scheduleDTO;
    }
    @GetMapping("/ScheduleFromMovie")
    public ResponseEntity<Object> getScheduleFromMovie(@RequestParam int movieId)
    {
        List<Schedule> schedules = scheduleRepository.getScheduleByMovieId(movieId);
        if (schedules == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Schedule not found");
        List<ShowScheduleDTO> schedulesDTOs = schedules.stream().map(
                schedule -> modelMapper.map(schedule, ShowScheduleDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(schedulesDTOs);
    }
    
    @GetMapping("/TimeFromMovieAndDate")
    public ResponseEntity<Object> getTimeFromMovieAndDate(@RequestParam int movieId, @RequestParam String startDate) {
        List<Schedule> showTimeDTObjects = scheduleRepository.getTimeByMovieIdAndDate(movieId, startDate);
        List<ShowTimeDTO> showTimeDTOs = showTimeDTObjects.stream().map(
            data -> modelMapper.map(data, ShowTimeDTO.class)
        ).collect(Collectors.toList());

    
        if (showTimeDTOs == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time not found");
        
        return ResponseEntity.ok(showTimeDTOs);
    }

}
