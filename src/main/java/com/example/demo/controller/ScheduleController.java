package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.dto.SeatDTO;
import com.example.demo.dto.ShowScheduleDTO;
import com.example.demo.dto.ShowTimeDTO;
import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Bill;
import com.example.demo.model.Room;
import com.example.demo.model.Schedule;
import com.example.demo.model.Seat;
import com.example.demo.model.Ticket;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.ScheduleService;

@RequestMapping("/api")
@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatRepository seatRepository;



    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/schedule")
    public ScheduleDTO getSchedule(@RequestParam("id") int id) {
        // Schedule schedule = scheduleRepository.findById(id).orElse(null);
        // ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);
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
                data -> modelMapper.map(data, ShowTimeDTO.class)).collect(Collectors.toList());

        if (showTimeDTOs == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time not found");

        return ResponseEntity.ok(showTimeDTOs);
    }


    @GetMapping("/{scheduleId}/seats")
    public ResponseEntity<Object> getSeatsFromSchedule(@PathVariable Integer scheduleId) {
    
        List<SeatDTO> seatDTOs = new ArrayList<SeatDTO>(); //
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(scheduleId);
    if (optionalSchedule.isPresent()) {
        Schedule schedule = optionalSchedule.get();
        Room room = schedule.getRoom();
        List<Seat> seats = seatRepository.findSeatsByRoom(room.getId());
        if( seats.isEmpty())
            return ResponseEntity.notFound().build();
        List<Seat> seatIsOccupieds = seatRepository.findSeatsIsOccupiedBySchedule(scheduleId);
        for (Seat seat : seats) {
            SeatDTO seatDTO = new SeatDTO();
            seatDTO.setId(seat.getId());
            seatDTO.setName(seat.getName());
            for (Seat seatIsOccupid : seatIsOccupieds) {

                if (seat.getId() == seatIsOccupid.getId())
                    seatDTO.setIsOccupied(1);
                else
                    seatDTO.setIsOccupied(0);
            }
            seatDTOs.add(seatDTO);
        }
        return ResponseEntity.ok(seatDTOs);

    } else {
        return ResponseEntity.notFound().build();
    }
}

}
