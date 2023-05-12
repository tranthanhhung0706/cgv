package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

import javax.persistence.*;



@Data
@Table(name = "room")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int capacity;
	private double totalArea;

	@Column(length = 1000)
	private String imgURL;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	@JsonManagedReference
	private Branch branch;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonBackReference
	private Set<Seat> seats;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Schedule> schedules;


	public Set<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}


	// private Set<Seat> seats = new HashSet<Seat>(0);

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

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
