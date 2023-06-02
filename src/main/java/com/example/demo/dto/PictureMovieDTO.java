package com.example.demo.dto;

public class PictureMovieDTO {
	private Integer id;
	private String imgURL;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public PictureMovieDTO(Integer id, String imgURL) {
		super();
		this.id = id;
		this.imgURL = imgURL;
	}
	public PictureMovieDTO() {
		super();
	}
}
