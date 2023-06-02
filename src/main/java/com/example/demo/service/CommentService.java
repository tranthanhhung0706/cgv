package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.model.Comment;


public interface CommentService {
	CommentDTO save(CommentDTO commentDTO);
	List<CommentDTO> getCommnets(int id);
}
