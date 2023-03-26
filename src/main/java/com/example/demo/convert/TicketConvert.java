package com.example.demo.convert;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Bill;
import com.example.demo.model.Ticket;

@Component
public class TicketConvert {

    public Ticket toModel(TicketDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setQrImageURL(dto.getQrImageUrl());
        return ticket;
    }

    public TicketDTO toDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setBillId(ticket.getBill().getId());
        dto.setId(ticket.getId());
        dto.setQrImageUrl(ticket.getQrImageURL());
        dto.setScheduleId(ticket.getSchedule().getId());
        dto.setSeatName(ticket.getSeat().getName());
        dto.setSeatId(ticket.getSeat().getId());
        return dto;
    }
}
