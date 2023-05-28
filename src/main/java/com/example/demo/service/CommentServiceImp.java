package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.CommentConVert;
import com.example.demo.dto.CommentDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.Movie;
import com.example.demo.model.User;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CommentConVert commentConVert;

	@Override
	public CommentDTO save(CommentDTO commentDTO) {
		User user = userService.findUserByUsername(commentDTO.getUserName());
		Movie movie = movieService.FindById(commentDTO.getMovie_id());
		Comment comment = commentConVert.toEntity(commentDTO);
		comment.setUser(user);
		comment.setMovie(movie);
		comment = commentRepository.save(comment);
		return commentConVert.toDTO(comment);
	}

	@Override
	public List<CommentDTO> getCommnets(int id) {
		List<Comment> comments = commentRepository.findAll();
		List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>();
		if(comments == null)
			return null;
		for (Comment comment : comments) {
			if(comment.getMovie().getId() == id)
				commentDTOs.add(commentConVert.toDTO(comment));
		}
		return commentDTOs;
	}
}
