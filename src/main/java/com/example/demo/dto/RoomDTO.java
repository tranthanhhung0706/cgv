package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Branch;
import com.example.demo.model.Room;
import com.example.demo.model.Seat;

public class RoomDTO {
    private int id;
    private String name;
    private int capacity;
    private double totalArea;
    private String imgURL;
    private Branch branch;
    private Map<Integer, String> seatList;

    public RoomDTO() {

    }

    public RoomDTO(int id, String name, int capacity, double totalArea, String imgURL, Branch branch,
            Map<Integer, String> seatList) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
        this.totalArea = totalArea;
        this.imgURL = imgURL;
        this.branch = branch;
        this.seatList = seatList;
    }

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.capacity = room.getCapacity();
        this.name = room.getName();
        this.totalArea = room.getTotalArea();
        this.imgURL = room.getImgURL();
        this.branch = room.getBranch();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getTotalArea() {
        return this.totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public String getImgURL() {
        return this.imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Map<Integer, String> getSeatList() {
        return this.seatList;
    }

    public void setSeatList(Map<Integer, String> seatList) {
        this.seatList = seatList;
    }

}
