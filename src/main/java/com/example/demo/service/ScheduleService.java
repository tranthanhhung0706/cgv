package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ScheduleDTO;

public interface ScheduleService {

    List<ScheduleDTO> getAllSchedule();

    ScheduleDTO findById(Integer id);
    ScheduleDTO save(ScheduleDTO scheduleDTO);
    void delete(int id);
    List<ScheduleDTO> getSchedule(Integer idMovie, Integer idBranch);
    List<ScheduleDTO> getSchedule(Integer idMovie);

}
