package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ScheduleDTO;

public interface ScheduleService {

    List<ScheduleDTO> getAllSchedule();

    ScheduleDTO findById(Integer id);

}
