package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	@JsonManagedReference
    private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
    private User user;
	
	@Column(name = "content")
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Comment(Integer id, Movie movie, User user, String content) {
		super();
		this.id = id;
		this.movie = movie;
		this.user = user;
		this.content = content;
	}

	public Comment() {
		super();
	}
}
