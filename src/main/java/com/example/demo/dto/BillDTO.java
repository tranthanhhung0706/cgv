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
	private int isPaied;

	public int getIsPaied() {
		return this.isPaied;
	}

	public void setIsPaied(int isPaied) {
		this.isPaied = isPaied;
	}

    private List<TicketDTO> tickets;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<TicketDTO> getTickets() {
		return tickets;
	}
	public void setTickets(List<TicketDTO> tickets) {
		this.tickets = tickets;
	}
}
