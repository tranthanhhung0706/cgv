package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.convert.CommentConVert;
import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@RequestMapping("/api")
@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentConVert commentConVert;
	
	@PostMapping("comment")
	public CommentDTO addComment(@RequestBody CommentDTO commentDTO) {
		return commentService.save(commentDTO);
	}
	
	@GetMapping("comment/{id_movie}")
	public List<CommentDTO> getComment(@PathVariable int id_movie){
		return commentService.getCommnets(id_movie);
	}
}
