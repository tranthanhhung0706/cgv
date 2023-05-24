package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
	// private org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduleDTO.class);
	private int id;
	private int price;
	private String startDate;
	private String startTime;
	private String branchName;
	private String movieName;
	private RoomDTO room;
	private List<String> seats = new ArrayList<>();

	public ScheduleDTO(Schedule schedule) {
		if (schedule != null) {
			this.id = schedule.getId();
			this.price = (int) schedule.getPrice();
			this.startDate = schedule.getStartDate().toString();
			this.startTime = schedule.getStartTime().toString();
			this.branchName = schedule.getBranch().getName();
			this.movieName = schedule.getMovie().getName();
		}

	}

	public ScheduleDTO(Schedule schedule, List<String> seats) {
		this.id = schedule.getId();
		this.price = (int) schedule.getPrice();
		this.startDate = schedule.getStartDate().toString();
		this.startTime = schedule.getStartTime().toString();
		this.branchName = schedule.getBranch().getName();
		this.movieName = schedule.getMovie().getName();
		//this.seats.addAll(seats);
	}

	public ScheduleDTO(Schedule schedule, RoomDTO roomDto) {
		this.id = schedule.getId();
		this.price = (int) schedule.getPrice();
		this.startDate = schedule.getStartDate().toString();
		this.startTime = schedule.getStartTime().toString();
		this.branchName = schedule.getBranch().getName();
		this.movieName = schedule.getMovie().getName();
		//this.room = roomDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate.toString();
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime.toString();
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

	/*
	 * public RoomDTO getRoom() { return room; }
	 * 
	 * public void setRoom(RoomDTO room) { this.room = room; }
	 * 
	 * public List<String> getSeats() { return seats; }
	 * 
	 * public void setSeats(List<String> seats) { this.seats = seats; }
	 */
	
}
