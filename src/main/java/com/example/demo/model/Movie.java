package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Table(name = "movie")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
	@Column(length = Integer.MAX_VALUE, columnDefinition = "TEXT")
    private String smallImageURl;
    @Column(length = 500)
    private String shortDescription;
    @Column(length = 1000)
    private String longDescription;
    @Column(length = Integer.MAX_VALUE, columnDefinition = "TEXT")
    private String largeImageURL;
    private String director;
    private String actors;
    private String categories;
    private LocalDate releaseDate;
    private int duration;
    @Column(length = 1000)
    private String trailerURL;
    private String language;
    private String rated;
	private int isShowing;
	@Column(columnDefinition = "TEXT")
 	private String largeImageString;

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
	public String getSmallImageURl() {
		return smallImageURl;
	}
	public void setSmallImageURl(String smallImageURl) {
		this.smallImageURl = smallImageURl;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getLargeImageURL() {
		return largeImageURL;
	}
	public void setLargeImageURL(String largeImageURL) {
		this.largeImageURL = largeImageURL;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getTrailerURL() {
		return trailerURL;
	}
	public void setTrailerURL(String trailerURL) {
		this.trailerURL = trailerURL;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public int getIsShowing() {
		return isShowing;
	}
	public void setIsShowing(int isShowing) {
		this.isShowing = isShowing;
	}
}
