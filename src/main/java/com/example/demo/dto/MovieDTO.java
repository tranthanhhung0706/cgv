package com.example.demo.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MovieDTO {
	private Integer id;
	private String image;
    private String name;
    private String date;
    private String catogery;
    private String Description;
    
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCatogery() {
		return catogery;
	}
	public void setCatogery(String catogery) {
		this.catogery = catogery;
	}
	// public MovieDTO(Integer id,String image, String name, String date, String catogery) {
	// 	super();
	// 	this.id = id;
	// 	this.image = image;
	// 	this.name = name;
	// 	this.date = date;
	// 	this.catogery = catogery;
	// }
	// public MovieDTO() {
	// 	super();
	// }
    
	
}
