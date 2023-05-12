package com.example.demo.dto;

import lombok.Data;

@Data
public class SeatDTO {
    private int id;
    private String name;
	private int isOccupied;
	
	
	public SeatDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public SeatDTO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsOccupied() {
		return isOccupied;
	}
	public void setIsOccupied(int isOccupied) {
		this.isOccupied = isOccupied;
	}
}
