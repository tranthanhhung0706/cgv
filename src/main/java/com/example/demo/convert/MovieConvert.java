package com.example.demo.convert;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.demo.dto.MovieDTO;
import com.example.demo.model.Movie;
@Component
public class MovieConvert {
		public MovieDTO toDto(Movie entity) {
			MovieDTO movieDTO=new MovieDTO();
			movieDTO.setId(entity.getId());
			movieDTO.setName(entity.getName());
			movieDTO.setImage(entity.getLargeImageURL());
			movieDTO.setDate(entity.getReleaseDate().toString());
			movieDTO.setCatogery(entity.getCategories());
			movieDTO.setDescription(entity.getShortDescription());
			return movieDTO;
		}
		public Movie toEntity(MovieDTO movieDTO) {
			Movie movie=new Movie();
//			movie.setId(movieDTO.getId());
			movie.setName(movieDTO.getName());
			movie.setLargeImageURL(movieDTO.getImage());
			movie.setReleaseDate(LocalDate.parse(movieDTO.getDate()));
			movie.setCategories(movieDTO.getCatogery());
			movie.setShortDescription(movieDTO.getDescription());
			return movie;
		}
		public Movie toEntity2(MovieDTO movieDTO,Movie movie) {
//			movie.setId(movieDTO.getId());
			movie.setName(movieDTO.getName());
			movie.setLargeImageURL(movieDTO.getImage());
			movie.setReleaseDate(LocalDate.parse(movieDTO.getDate()));
			movie.setCategories(movieDTO.getCatogery());
			movie.setShortDescription(movieDTO.getDescription());
			return movie;
		}
}
