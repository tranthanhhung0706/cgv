package com.example.demo.dto;

public class CommentDTO {
	private String userName;
    private String content;
    private int movie_id;
    
    

    public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public CommentDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentDTO(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }
}
