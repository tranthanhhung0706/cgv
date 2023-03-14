package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

@Data
@Table(name = "customer")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
    private String name;
    private LocalDate birthday;
    private String phone_number;
    private String address;
    public Customer(String name, LocalDate birthday, String phone_number, String address) {
        this.name = name;
        this.birthday = birthday;
        this.phone_number = phone_number;
        this.address = address;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
    

}
