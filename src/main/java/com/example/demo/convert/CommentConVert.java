package com.example.demo.convert;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CommentDTO;
import com.example.demo.model.Comment;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

@Component
public class CommentConVert {
	
	@Autowired
	private UserService userService;
	private org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduleConvert.class);
	
	public CommentDTO toDTO(Comment comment) {
		CommentDTO dto = new CommentDTO();
		dto.setUserName(comment.getUser().getUsername());
		dto.setContent(comment.getContent());
		dto.setMovie_id(comment.getMovie().getId());
		return dto;
	}
	
	public Comment toEntity(CommentDTO dto) {
		Comment comment = new Comment();
		comment.setContent(dto.getContent());
		return comment;
	}
	
	public Comment toEntity(CommentDTO dto, Comment old) {
		old.setContent(dto.getContent());
		return old;
	}
}
