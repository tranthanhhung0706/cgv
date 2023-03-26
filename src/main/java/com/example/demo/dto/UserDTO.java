package com.example.demo.dto;


import java.time.LocalDate;
import java.util.Set;

import com.example.demo.model.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDTO {

	    private String username;

	    private String password;

		private String fullName;

		private String phone_number;

		@JsonFormat(pattern="dd/MM/yyyy")
		private LocalDate birthday;

		private String Address;

	    private Set<Role> roles;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		


		public String getPhone_number() {
			return this.phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		public LocalDate getBirthday() {
			return this.birthday;
		}

		public void setBirthday(LocalDate birthday) {
			this.birthday = birthday;
		}

		public String getAddress() {
			return this.Address;
		}

		public void setAddress(String Address) {
			this.Address = Address;
		}
		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

	    // constructors, getters and setters
	    
	    
	
}
