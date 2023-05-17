package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Bill;
import com.example.demo.model.Schedule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.ScheduleServiceImpl;

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
    private ScheduleService scheduleService;


//    @GetMapping("/schedule")
//    public ScheduleDTO getSchedule(@RequestParam("id") int id) {
//        Schedule schedule = scheduleRepository.findById(id).orElse(null);
//        ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);
//
//        List<Ticket> tickets = ticketRepository.findBySchedule(schedule);
//        List<String> seats = new ArrayList<>();
//
//        for (Ticket ticket : tickets) {
//            seats.add(ticket.getSeat().getName());
//        }
//        // Collections.sort(seats);
//        scheduleDTO.setSeats(seats);
//        return scheduleDTO;
//    }
//    
    @GetMapping("/schedule")
    public List<ScheduleDTO> getSchedule() {
        return scheduleService.getAllSchedule();
    }
    
    @PostMapping("/schedule")
    public ScheduleDTO newSchedule(@RequestBody ScheduleDTO scheduleDTO) {
    	return scheduleService.save(scheduleDTO);
    }
    
    @PutMapping("/schedule/{id}")
    public ScheduleDTO updateSchedule(@RequestBody ScheduleDTO scheduleDTO, @PathVariable int id)
    {
    	scheduleDTO.setId(id);
    	return scheduleService.save(scheduleDTO);
    }
    
    @DeleteMapping("/schedule/{id}")
    public void deleteSchdule(@PathVariable int id) {
    	scheduleService.delete(id);
    }

    @GetMapping("/schedule/{idMovie}")
    public List<ScheduleDTO> getSchdules(@PathVariable int idMovie) {
    	return scheduleService.getSchedule(idMovie);
    }
    
    @GetMapping("/schedule/{idMovie}/{idBranch}")
    public List<ScheduleDTO> getSchdules(@PathVariable int idMovie, @PathVariable int idBranch) {
    	return scheduleService.getSchedule(idMovie, idBranch);
    }
}
