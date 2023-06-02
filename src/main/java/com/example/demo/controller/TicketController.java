package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillDTO;
import com.example.demo.dto.TicketDTO;
import com.example.demo.dto.TicketDTO2;
import com.example.demo.model.Bill;
import com.example.demo.model.Seat;
import com.example.demo.model.Ticket;
import com.example.demo.repository.SeatRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.BillService;
import com.example.demo.service.TicketService;
import com.example.demo.service.UserService;

@RequestMapping("/api")
@RestController
public class TicketController {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    TicketService ticketService;
    @Autowired
    BillService billService;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/tickets")
    public ResponseEntity<?> checkOut(@RequestBody List<TicketDTO> ticketDTOs) {

        Bill bill = new Bill();
        bill.setCreatedTime(LocalDateTime.now());
        bill.setUser(userService.findByUsername(authenticationService.getCurrenUser().getUsername()).orElse(null));
        if (bill.getUser() == null) {
            return ResponseEntity.badRequest().body("Error authentication!!!");
        }
        bill = billService.save(bill);
        try {
            int billId = bill.getId();
            for (TicketDTO ticketDTO : ticketDTOs) {
                ticketDTO.setBillId(billId);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Error create bill!!!");
        }

        try {
            List<Ticket> res = ticketService.saveAll(ticketDTOs);

            if (res == null) {
                // delete bill created
                billService.deleteById(bill.getId());
                return ResponseEntity.badRequest().body("Error checkout ticket!! ");
            }
        } catch (Exception e) {
            // TODO: handle exception
            billService.deleteById(bill.getId());
            return ResponseEntity.badRequest().body("Error checkout ticket!! " + e.getLocalizedMessage());
        }

        List<BillDTO> response = new ArrayList<>();
        response.add(billService.findById(bill.getId()));

        return ResponseEntity.ok(response);
    }

    //reactjs
    @PostMapping("/checkOutMovie")
    public ResponseEntity<?> checkOutMovie(@RequestBody List<TicketDTO2> ticketDTO2s) {

        Bill bill = new Bill();
        bill.setCreatedTime(LocalDateTime.now());
        bill.setUser(userService.findByUsername(authenticationService.getCurrenUser().getUsername()).orElse(null));
        bill.setIsPaied(1);
        if (bill.getUser() == null) {
            return ResponseEntity.badRequest().body("Error authentication!!!");
        }
        bill = billService.save(bill);
        //List<TicketDTO> ticketDTOs = new ArrayList<>();

        List<TicketDTO> ticketDTOs = ticketDTO2s.stream().map(
                data -> modelMapper.map(data, TicketDTO.class)).collect(Collectors.toList());

        try {
            for (int i = 0; i < ticketDTO2s.size(); i++) {
                Seat seat = seatRepository.findById(ticketDTO2s.get(i).getSeatId()).orElse(null);
                if( seat == null) return ResponseEntity.notFound().build();
                
                ticketDTOs.get(i).setSeatName(seat.getName());

            }
            
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("failed to get seat");
        }       
    
        try {
            int billId = bill.getId();

            for (TicketDTO ticketDTO : ticketDTOs) {
                ticketDTO.setBillId(billId);
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Error create bill!!!");
        }

        try {
            List<Ticket> res = ticketService.saveAll(ticketDTOs);

            if (res == null) {
                // delete bill created
                billService.deleteById(bill.getId());
                return ResponseEntity.badRequest().body("Error checkout ticket!! ");
            }
        } catch (Exception e) {
            // TODO: handle exception
            billService.deleteById(bill.getId());
            return ResponseEntity.badRequest().body("Error checkout ticket!! " + e.getLocalizedMessage());
        }

        List<BillDTO> response = new ArrayList<>();
        response.add(billService.findById(bill.getId()));

        return ResponseEntity.ok(response);
    }



    
    @GetMapping("/tickets")
    public ResponseEntity<?> getTickets() {
        try {
            List<TicketDTO> response = ticketService.getAll();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Error get all tickets!" + e.getLocalizedMessage());
        }
    }

    @GetMapping("/ticket")
    public ResponseEntity<?> getTickets(@RequestParam("id") int id) {
        try {
            TicketDTO response = ticketService.findById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Error get ticket by id!! " + e.getLocalizedMessage());
        }
    }

    @GetMapping("/tickets/{userID}")
    public ResponseEntity<?> getAllByUser(@PathVariable Integer userID) {
        try {
            return ResponseEntity.ok(ticketService.getAllByUser(userID));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Error get ticket by user id !!  " + e.getLocalizedMessage());
        }
    }

    
}
