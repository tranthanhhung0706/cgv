package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
  // @Query("SELECT m FROM Movie WHERE s.releaseDate:=releaseDate and
  // m.isShowing=1")
  // List<Movie> findMovieIsShowing(@Param("releaseDate") LocalDate releaseDate);

  List<Movie> findByIsShowing(int isShowing);
}
