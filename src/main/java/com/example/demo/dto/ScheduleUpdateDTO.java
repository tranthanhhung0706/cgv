package com.example.demo.dto;

import com.example.demo.model.Branch;
import com.example.demo.model.Movie;
import com.example.demo.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleUpdateDTO {
    private int id;
    private String startDate;
    private String startTime;
    private double price;
    private int movieId;
    private int branchId;
    private int roomId;
}
