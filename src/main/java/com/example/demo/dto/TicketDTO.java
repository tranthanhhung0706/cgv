package com.example.demo.dto;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private int id;
    private String qrImageUrl;
    private int billId;
    private int scheduleId;
    private String seatName;
    private int seatId;

}
