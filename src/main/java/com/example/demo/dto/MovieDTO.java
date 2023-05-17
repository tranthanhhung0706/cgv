package com.example.demo.dto;

import java.util.List;

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
	private String smallImageURl;
	private String name;
	private String date;
	private String catogery;
	private int duration;
	private String actors;
	private String Description;
	private String largeImageURL;
	private List<ScheduleDTO> lScheduleDTOs;

	public List<ScheduleDTO> getlScheduleDTOs() {
		return lScheduleDTOs;
	}

	public void setlScheduleDTOs(List<ScheduleDTO> lScheduleDTOs) {
		this.lScheduleDTOs = lScheduleDTOs;
	}

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

	public String getSmallImageURl() {
		return smallImageURl;
	}

	public void setSmallImageURl(String smallImageURl) {
		this.smallImageURl = smallImageURl;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getLargeImageURL() {
		return largeImageURL;
	}

	public void setLargeImageURL(String largeImageURL) {
		this.largeImageURL = largeImageURL;
	}
}
