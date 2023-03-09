package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.MovieDTO;
import com.example.demo.model.User;
import com.example.demo.service.MovieService;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
public class MovieController {
		@Autowired
		private MovieService movieService;
		
		@GetMapping("/movie")
		public List<MovieDTO> getAllMovie(){
			//lol danh
			return movieService.getAllMovie();
		}
		@PostMapping("/movie")
		public MovieDTO saveMovie(@RequestBody MovieDTO movieDTO) {
			movieService.save(movieDTO);
			return movieDTO;
		}
		@PutMapping("movie/{id}")
		public MovieDTO update(@RequestBody MovieDTO movieDTO,@PathVariable int id) {
			try {
				movieDTO.setId(id);
			    movieService.update(movieDTO);
			// movieService.save(movieDTO);
			   return movieDTO;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		@DeleteMapping("/movie/{id}")
		public 	List<MovieDTO> delete(@PathVariable int id) {
			if (movieService.findById(id).getId()!=null) {
				movieService.delete(id);
			}
			return movieService.getAllMovie();
		}
}
