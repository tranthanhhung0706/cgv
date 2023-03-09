package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.convert.MovieConvert;
import com.example.demo.dto.MovieDTO;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
  @Autowired
  private MovieRepository movieRepository;
  @Autowired
  private MovieConvert movieConvert;
@Override
public List<MovieDTO> getAllMovie() {
	// TODO Auto-generated method stub
	List<Movie> list=movieRepository.findAll();
	List<MovieDTO> liMovieDTOs=new ArrayList();
	for(int i=0;i<list.size();i++) {
		liMovieDTOs.add(movieConvert.toDto(list.get(i)));
	}
//	System.out.println(liMovieDTOs.get(0).getName());
	return liMovieDTOs;
}
@Override
public void save(MovieDTO movieDTO) {
	// TODO Auto-generated method stub
	Movie movie=movieConvert.toEntity(movieDTO);
	movieRepository.save(movie);
}
@Override
public void update(MovieDTO movieDTO) {
	Movie oldmovie=movieRepository.getById(movieDTO.getId());
	Movie newmovie=movieConvert.toEntity2(movieDTO, oldmovie);
	movieRepository.save(newmovie);
}
@Override
public void delete(Integer id) {
	// TODO Auto-generated method stub
	movieRepository.deleteById(id);
}
@Override
public MovieDTO findById(Integer id) {
	// TODO Auto-generated method stub
	Movie movie=new Movie();
    movie=movieRepository.getOne(id);
	return movieConvert.toDto(movie);
}

  
}
