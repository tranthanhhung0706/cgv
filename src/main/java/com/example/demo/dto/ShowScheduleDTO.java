package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowScheduleDTO {
    private int id;
    private LocalDate startDate;
    private LocalTime startTime;
    private BranchDTO branch;
}
