package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.TicketConvert;
import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Bill;
import com.example.demo.model.Schedule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    TicketConvert ticketConvert;

    @Override
    public List<TicketDTO> getAll() {
        // TODO Auto-generated method stub
        List<TicketDTO> dtos = new ArrayList<>();
        for (Ticket ticket : ticketRepository.findAll()) {
            dtos.add(ticketConvert.toDTO(ticket));
        }
        return dtos;
    }

    @Override
    public TicketDTO findById(Integer id) {
        // TODO Auto-generated method stub
        return ticketConvert.toDTO(ticketRepository.findById(id).orElse(null));
    }

    @Override
    public void save(TicketDTO ticketDTO) {
        // TODO Auto-generated method stub
        Ticket ticket = ticketConvert.toModel(ticketDTO);
        ticket.setBill(billRepository.findById(ticketDTO.getBillId()).orElse(null));
        Schedule sche = scheduleRepository.findById(ticketDTO.getScheduleId()).orElse(null);
        ticket.setSchedule(sche);
        ticket.setSeat(
                // seatRepository.findSeatByRoomIdAndSeatName(sche.getRoom().getId(),
                // ticketDTO.getSeatName()).get(0));
                seatRepository.findById(ticketDTO.getSeatId()).orElse(null));
        try {
            ticketRepository.save(ticket);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error save ticket!! " + e.getMessage());
        }
    }

    @Override
    public List<Ticket> saveAll(List<TicketDTO> ticketDTOs) {
        // TODO Auto-generated method stub

        List<Ticket> tickets = new ArrayList<>();
        for (TicketDTO ticketDTO : ticketDTOs) {
            // check ticketId is instance??

            //
            Ticket ticket = ticketConvert.toModel(ticketDTO);
            ticket.setBill(billRepository.findById(ticketDTO.getBillId()).orElse(null));
            Schedule sche = scheduleRepository.findById(ticketDTO.getScheduleId()).orElse(null);
            ticket.setSchedule(sche);
            ticket.setSeat(
                    seatRepository.findById(ticketDTO.getSeatId()).orElse(null));

            tickets.add(ticket);
        }

        try {
            // for (Ticket ticket : tickets) {
            // ticketRepository.save(ticket);
            // }
            return ticketRepository.saveAll(tickets);
        } catch (Exception e) {
            // TODO: handle exceptiont
            System.out.println("error save all ticket!! " + e.getMessage());
            throw e;
            // return null;
        }
    }

    @Override
    public void update(TicketDTO ticketDTO) {
        // TODO Auto-generated method stub
        Ticket ticket = ticketConvert.toModel(ticketDTO);
        ticket.setBill(billRepository.findById(ticketDTO.getBillId()).orElse(null));
        ticket.setSchedule(scheduleRepository.findById(ticketDTO.getScheduleId()).orElse(null));
        Schedule sche = scheduleRepository.findById(ticketDTO.getScheduleId()).orElse(null);
        ticket.setSchedule(sche);
        ticket.setSeat(
                seatRepository.findSeatByRoomIdAndSeatName(sche.getRoom().getId(), ticketDTO.getSeatName()).get(0));

        try {
            ticketRepository.save(ticket);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error update ticket!! " + e.getMessage());
        }
    }

    @Override
    public void delete(TicketDTO ticketDTO) {
        // TODO Auto-generated method stub
        Ticket ticket = ticketConvert.toModel(ticketDTO);
        ticket.setBill(billRepository.findById(ticketDTO.getBillId()).orElse(null));
        ticket.setSchedule(scheduleRepository.findById(ticketDTO.getScheduleId()).orElse(null));
        Schedule sche = scheduleRepository.findById(ticketDTO.getScheduleId()).orElse(null);
        ticket.setSchedule(sche);
        ticket.setSeat(
                seatRepository.findSeatByRoomIdAndSeatName(sche.getRoom().getId(), ticketDTO.getSeatName()).get(0));

        ticketRepository.delete(ticket);
    }

    @Override
    public List<TicketDTO> findByBill(Bill bill) {
        // TODO Auto-generated method stub
        List<Ticket> tickets = ticketRepository.findByBill(bill);
        List<TicketDTO> dtos = new ArrayList<>();
        for (Ticket ticket : tickets) {
            dtos.add(ticketConvert.toDTO(ticket));
        }
        return dtos;
    }

    @Override
    public List<TicketDTO> findBySchedule(Schedule schedule) {
        // TODO Auto-generated method stub
        List<Ticket> tickets = ticketRepository.findBySchedule(schedule);
        List<TicketDTO> dtos = new ArrayList<>();
        for (Ticket ticket : tickets) {
            dtos.add(ticketConvert.toDTO(ticket));
        }
        return dtos;
    }

}
