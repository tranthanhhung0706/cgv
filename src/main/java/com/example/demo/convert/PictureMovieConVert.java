package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.PictureMovieDTO;
import com.example.demo.model.PictureMovie;

@Component
public class PictureMovieConVert {
	public PictureMovieDTO toDTO(PictureMovie pictureMovie) {
		PictureMovieDTO pictureMovieDTO = new PictureMovieDTO();
		pictureMovieDTO.setId(pictureMovie.getId());
		pictureMovieDTO.setImgURL(pictureMovie.getImageURl());
		return pictureMovieDTO;
	}
	
	public PictureMovie toEntity(PictureMovieDTO pictureMovieDTO) {
		PictureMovie pictureMovie = new PictureMovie();
		pictureMovie.setId(pictureMovieDTO.getId());
		pictureMovie.setImageURl(pictureMovieDTO.getImgURL());
		return pictureMovie;
	}
	
	public PictureMovie toEntity(PictureMovieDTO pictureMovieDTO, PictureMovie pictureMovie) {
		pictureMovie.setImageURl(pictureMovieDTO.getImgURL());
		return pictureMovie;
	}
}
