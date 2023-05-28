package com.example.demo.convert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.MovieDTO2;
import com.example.demo.dto.PictureMovieDTO;
import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.Movie;
import com.example.demo.model.PictureMovie;
import com.example.demo.model.Schedule;
@Component
public class MovieConvert {
		@Autowired
		public ScheduleConvert scheduleConvert;
		@Autowired
		public PictureMovieConVert pictureMovieConVert;
		@Autowired
		private CommentConVert commentConVert;
	
		public MovieDTO toDto(Movie entity) {
			MovieDTO movieDTO=new MovieDTO();
			movieDTO.setId(entity.getId());
			movieDTO.setName(entity.getName());
			movieDTO.setLargeImageURL(entity.getLargeImageURL());
			movieDTO.setDate(entity.getReleaseDate().toString());
			movieDTO.setCatogery(entity.getCategories());
			movieDTO.setShortDescription(entity.getShortDescription());
			movieDTO.setLongDescription(entity.getLongDescription());
			movieDTO.setActors(entity.getActors());
			movieDTO.setDuration(entity.getDuration());
			movieDTO.setSmallImageURl(entity.getSmallImageURl());
			List<PictureMovieDTO> listPictureMovies = new ArrayList<PictureMovieDTO>();
			List<ScheduleDTO> lisScheduleDTOs = new ArrayList<ScheduleDTO>();
			List<CommentDTO> liCommentDTOs = new ArrayList<CommentDTO>();
			for(PictureMovie pictureMovie: entity.getPictureMovies())
				listPictureMovies.add(pictureMovieConVert.toDTO(pictureMovie));
			for(Schedule schedule: entity.getSchedules())
				lisScheduleDTOs.add(scheduleConvert.toDTO(schedule));
			for(Comment comment: entity.getComments()) {
				liCommentDTOs.add(commentConVert.toDTO(comment));
			}
			movieDTO.setlPictureMovieDTOs(listPictureMovies);
			movieDTO.setlScheduleDTOs(lisScheduleDTOs);
			movieDTO.setlCommentDTOs(liCommentDTOs);
			return movieDTO;
		}
		
		public Movie toEntity(MovieDTO movieDTO) {
			Movie movie=new Movie();
//			movie.setId(movieDTO.getId());
			movie.setName(movieDTO.getName());
			movie.setLargeImageURL(movieDTO.getLargeImageURL());
			movie.setReleaseDate(LocalDate.parse(movieDTO.getDate()));
			movie.setCategories(movieDTO.getCatogery());
			movie.setShortDescription(movieDTO.getShortDescription());
			movie.setLongDescription(movieDTO.getLongDescription());
			return movie;
		}
		public Movie toEntity2(MovieDTO movieDTO,Movie movie) {
//			movie.setId(movieDTO.getId());
			movie.setName(movieDTO.getName());
			movie.setLargeImageURL(movieDTO.getLargeImageURL());
			movie.setReleaseDate(LocalDate.parse(movieDTO.getDate()));
			movie.setCategories(movieDTO.getCatogery());
			movie.setShortDescription(movieDTO.getShortDescription());
			movie.setLongDescription(movieDTO.getLongDescription());
			return movie;
		}
}
