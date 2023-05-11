package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.ShowScheduleDTO;
import com.example.demo.dto.ShowTimeDTO;
import com.example.demo.model.Schedule;


public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query("SELECT s FROM Schedule s WHERE s.movie.id = :movieId ORDER BY s.startDate DESC")
    List<Schedule> getScheduleByMovieId(@Param("movieId") Integer movieId);
 
    @Query(value = "select * from cinemaa.schedule s where start_date = :startDate and start_date <= CURDATE() and movie_id= :movieId ;", nativeQuery = true)
    List<Schedule> getTimeByMovieIdAndDate(@Param("movieId") Integer movieId,
            @Param("startDate") String startDate);


}
