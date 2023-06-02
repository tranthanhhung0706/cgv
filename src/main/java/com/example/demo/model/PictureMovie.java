package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pictureMovie")

public class PictureMovie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "imgURL")
	private String ImageURl;
	
	@ManyToOne
   // @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "movie_id")
	@JsonManagedReference
    private Movie movie;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageURl() {
		return ImageURl;
	}

	public void setImageURl(String imageURl) {
		ImageURl = imageURl;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public PictureMovie(Integer id, String imageURl, Movie movie) {
		super();
		this.id = id;
		ImageURl = imageURl;
		this.movie = movie;
	}

	public PictureMovie() {
		super();
	}
	
}
