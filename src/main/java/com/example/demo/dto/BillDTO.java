package com.example.demo.dto;


import com.example.demo.model.User;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillDTO {
    private int id;
    private LocalDateTime createdTime;
    private List<TicketDTO> listTickets;
    private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public List<TicketDTO> getListTickets() {
		return listTickets;
	}
	public void setListTickets(List<TicketDTO> listTickets) {
		this.listTickets = listTickets;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
