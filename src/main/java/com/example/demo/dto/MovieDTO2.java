package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class MovieDTO2 {
	private int id;
	private String name;

	private String smallImageURl;

	private String shortDescription;

	private String longDescription;

	private String largeImageURL;
	private String director;
	private String actors;
	private String categories;
	private LocalDate releaseDate;
	private int duration;
	private String trailerURL;
	private String language;
	private String rated;
	private int isShowing;

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

	public String getSmallImageURl() {
		return this.smallImageURl;
	}

	public void setSmallImageURl(String smallImageURl) {
		this.smallImageURl = smallImageURl;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getLargeImageURL() {
		return this.largeImageURL;
	}

	public void setLargeImageURL(String largeImageURL) {
		this.largeImageURL = largeImageURL;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getCategories() {
		return this.categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTrailerURL() {
		return this.trailerURL;
	}

	public void setTrailerURL(String trailerURL) {
		this.trailerURL = trailerURL;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRated() {
		return this.rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public int getIsShowing() {
		return this.isShowing;
	}

	public void setIsShowing(int isShowing) {
		this.isShowing = isShowing;
	}
    
	
    
	
}
