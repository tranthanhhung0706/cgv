package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.MovieDTO;
import com.example.demo.model.Movie;

public interface MovieService {
	List<MovieDTO> getAllMovie();
	void save(MovieDTO movieDTO);
	void update(MovieDTO movieDTO);
	void delete(Integer id);
	MovieDTO findById(Integer id);
}
