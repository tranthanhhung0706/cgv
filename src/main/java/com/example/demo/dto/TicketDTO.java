package com.example.demo.dto;

import lombok.Data;

@Data
public class TicketDTO {
    private int id;
    private String qrImageURL;
    private ScheduleDTO schedule;
    private SeatDTO seat;
    private BillDTO bill;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQrImageURL() {
		return qrImageURL;
	}
	public void setQrImageURL(String qrImageURL) {
		this.qrImageURL = qrImageURL;
	}
	public ScheduleDTO getSchedule() {
		return schedule;
	}
	public void setSchedule(ScheduleDTO schedule) {
		this.schedule = schedule;
	}
	public SeatDTO getSeat() {
		return seat;
	}
	public void setSeat(SeatDTO seat) {
		this.seat = seat;
	}
	public BillDTO getBill() {
		return bill;
	}
	public void setBill(BillDTO bill) {
		this.bill = bill;
	}
}
