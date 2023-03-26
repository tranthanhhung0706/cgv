package com.example.demo.convert;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Schedule;

@Component
public class ScheduleConvert {
    public ScheduleDTO toDTO(Schedule sche) {
        ScheduleDTO scheDTO = new ScheduleDTO(sche);

        return scheDTO;
    }

    public ScheduleDTO toDTO(Schedule sche, List<String> seats) {
        ScheduleDTO scheDTO = new ScheduleDTO(sche, seats);

        return scheDTO;
    }
}
