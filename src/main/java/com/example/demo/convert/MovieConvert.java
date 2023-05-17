package com.example.demo.convert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.MovieDTO2;
import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Movie;
import com.example.demo.model.Schedule;
@Component
public class MovieConvert {
		@Autowired
		public ScheduleConvert scheduleConvert;
	
		public MovieDTO toDto(Movie entity) {
			MovieDTO movieDTO=new MovieDTO();
			movieDTO.setId(entity.getId());
			movieDTO.setName(entity.getName());
			movieDTO.setLargeImageURL(entity.getLargeImageURL());
			movieDTO.setDate(entity.getReleaseDate().toString());
			movieDTO.setCatogery(entity.getCategories());
			movieDTO.setDescription(entity.getShortDescription());
			movieDTO.setActors(entity.getActors());
			movieDTO.setDuration(entity.getDuration());
			movieDTO.setSmallImageURl(entity.getSmallImageURl());
			List<ScheduleDTO> list = new ArrayList<ScheduleDTO>();
			for (Schedule schedule : entity.getSchedules()) {
				list.add(scheduleConvert.toDTO(schedule));
			}
			movieDTO.setlScheduleDTOs(list);
			return movieDTO;
		}
		
		public Movie toEntity(MovieDTO movieDTO) {
			Movie movie=new Movie();
//			movie.setId(movieDTO.getId());
			movie.setName(movieDTO.getName());
			movie.setLargeImageURL(movieDTO.getLargeImageURL());
			movie.setReleaseDate(LocalDate.parse(movieDTO.getDate()));
			movie.setCategories(movieDTO.getCatogery());
			movie.setShortDescription(movieDTO.getDescription());
			return movie;
		}
		public Movie toEntity2(MovieDTO movieDTO,Movie movie) {
//			movie.setId(movieDTO.getId());
			movie.setName(movieDTO.getName());
			movie.setLargeImageURL(movieDTO.getLargeImageURL());
			movie.setReleaseDate(LocalDate.parse(movieDTO.getDate()));
			movie.setCategories(movieDTO.getCatogery());
			movie.setShortDescription(movieDTO.getDescription());
			return movie;
		}
}
