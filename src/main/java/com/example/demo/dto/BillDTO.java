package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {

    private int id;
    private List<TicketDTO> tickets;
}
