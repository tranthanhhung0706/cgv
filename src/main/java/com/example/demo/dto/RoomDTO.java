package com.example.demo.dto;

import lombok.Data;

@Data
public class RoomDTO {
    private int id;
    private String name;
    private int capacity;
    private double totalArea;
    private String imgURL;
    private BranchDTO branch;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public BranchDTO getBranch() {
		return branch;
	}
	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}
}
