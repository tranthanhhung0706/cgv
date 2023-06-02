package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDTO;
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
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.ScheduleServiceImpl;
import com.example.demo.service.TicketService;

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
    private TicketService ticketService; 

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/schedule-id")
    public ScheduleDTO getScheduleByIdCuaQuynhThan(@RequestParam("id") int id) {
        //plz dung sua cai api cua t
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);
        if (schedule.getRoom() != null) {
            RoomDTO roomDTO = new RoomDTO(schedule.getRoom());
            List<Seat> seatFromRoom = seatRepository.findSeatsByRoom(roomDTO.getId());
            Map<Integer, String> seatMap = new TreeMap<>();
            for (Seat seat : seatFromRoom) {
                seatMap.put(seat.getId(), seat.getName());
            }
            
            roomDTO.setSeatList(seatMap);
            String imgURL = schedule.getMovie().getSmallImageURl();
            scheduleDTO = new ScheduleDTO(schedule, roomDTO, imgURL);
        }

        List<Ticket> tickets = ticketRepository.findBySchedule(schedule);
        List<String> seats = new ArrayList<>();

        for (Ticket ticket : tickets) {
            seats.add(ticket.getSeat().getName());
        }

        // Collections.sort(seats);
        scheduleDTO.setSeats(seats);
        return scheduleDTO;
    }
    @GetMapping("/schedule")
    public ScheduleDTO getScheduleById(@RequestParam("id") int id) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);
        if (schedule.getRoom() != null) {
            RoomDTO roomDTO = new RoomDTO(schedule.getRoom());
            List<Seat> seatFromRoom = seatRepository.findSeatsByRoom(roomDTO.getId());
            Map<Integer, String> seatMap = new TreeMap<>();
            for (Seat seat : seatFromRoom) {
                seatMap.put(seat.getId(), seat.getName());
            }

            roomDTO.setSeatList(seatMap);
            scheduleDTO = new ScheduleDTO(schedule);
        }

        List<Ticket> tickets = ticketRepository.findBySchedule(schedule);
        List<String> seats = new ArrayList<>();

        for (Ticket ticket : tickets) {
            seats.add(ticket.getSeat().getName());
        }

        // Collections.sort(seats);
        //        scheduleDTO.setSeats(seats);
        return scheduleDTO;
    }

    @GetMapping("/scheduleByUserId")
    public List<ScheduleDTO> getScheduleByUserId(@RequestParam("id") int id, @RequestParam(name = "q", required = false)  String searchTerm) {
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        List<TicketDTO> ticketDTOs = ticketService.getAllByUser(id);
        for (TicketDTO ticketDTO : ticketDTOs) {

            try {
                Schedule schedule = scheduleRepository.findById(ticketDTO.getScheduleId()).orElse(null);
                ScheduleDTO scheduleDTO = new ScheduleDTO(schedule);
                scheduleDTOs.add(scheduleDTO);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
        if(searchTerm != null)
            scheduleDTOs =  scheduleDTOs.stream().filter(scheduleDTO -> scheduleDTO.getMovieName().toLowerCase().contains(searchTerm.toLowerCase())).collect(Collectors.toList());
        return scheduleDTOs;
    }
    


    @GetMapping("/schedules")
    public List<ScheduleDTO> getSchedule() {
        return scheduleService.getAllSchedule();
    }

    @PostMapping("/schedule")
    public ScheduleDTO newSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.save(scheduleDTO);
    }

    @PutMapping("/schedule/{id}")
    public ScheduleDTO updateSchedule(@RequestBody ScheduleDTO scheduleDTO, @PathVariable int id) {
        scheduleDTO.setId(id);
        return scheduleService.save(scheduleDTO);
    }

    @DeleteMapping("/schedule/{id}")
    public void deleteSchdule(@PathVariable int id) {
        scheduleService.delete(id);
    }

    @GetMapping("/ScheduleFromMovie")
    public ResponseEntity<Object> getScheduleFromMovie(@RequestParam int movieId) {
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
            if (seats.isEmpty())
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

    @GetMapping("/schedules/{idMovie}")
    public List<ScheduleDTO> getSchdules(@PathVariable int idMovie) {
        return scheduleService.getSchedule(idMovie);
    }

    @GetMapping("/schedule/{idMovie}/{idBranch}")
    public List<ScheduleDTO> getSchdules(@PathVariable int idMovie, @PathVariable int idBranch) {
        return scheduleService.getSchedule(idMovie, idBranch);
    }


}
