package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ScheduleDTO {
	//private org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduleDTO.class);
    private int id;
    private double price;
    private LocalDate startDate;
    private LocalTime startTime;
    private String branchName;
    private String movieName;
    private RoomDTO room;
    private List<String> seats;
    
    

    public ScheduleDTO() {
		//super();
    	//logger.info("Sppp");
	}

	public ScheduleDTO(Schedule schedule) {
        this.id = schedule.getId();
        this.price = schedule.getPrice();
        this.startDate = schedule.getStartDate();
        this.startTime = schedule.getStartTime();
        this.branchName = schedule.getBranch().getName();
        this.movieName = schedule.getMovie().getName();
        this.roomName = schedule.getRoom().getName();
        this.roomId = schedule.getRoom().getId();
    }

    public ScheduleDTO(Schedule schedule, List<String> seats) {
        this.id = schedule.getId();
        this.price = schedule.getPrice();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
}
