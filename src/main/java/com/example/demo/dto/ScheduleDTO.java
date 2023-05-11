package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.example.demo.model.Schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private int id;
    private int price;
    private LocalDate startDate;
    private LocalTime startTime;
    private String branchName;
    private String movieName;
    private RoomDTO room;
    private List<String> seats;

    public ScheduleDTO(Schedule schedule) {
        this.id = schedule.getId();
        this.price = (int) schedule.getPrice();
        this.startDate = schedule.getStartDate();
        this.startTime = schedule.getStartTime();
        this.branchName = schedule.getBranch().getName();
        this.movieName = schedule.getMovie().getName();
    }

    public ScheduleDTO(Schedule schedule, List<String> seats) {
        this.id = schedule.getId();
        this.price = (int) schedule.getPrice();
        this.startDate = schedule.getStartDate();
        this.startTime = schedule.getStartTime();
        this.branchName = schedule.getBranch().getName();
        this.movieName = schedule.getMovie().getName();
        this.seats.addAll(seats);
    }

    public ScheduleDTO(Schedule schedule, RoomDTO roomDto) {
        this.id = schedule.getId();
        this.price = (int) schedule.getPrice();
        this.startDate = schedule.getStartDate();
        this.startTime = schedule.getStartTime();
        this.branchName = schedule.getBranch().getName();
        this.movieName = schedule.getMovie().getName();
        this.room = roomDto;
        this.seats.addAll(seats);
    }
}
