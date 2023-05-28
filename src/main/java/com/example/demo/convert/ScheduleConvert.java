package com.example.demo.convert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Schedule;
import org.slf4j.LoggerFactory;

@Component
public class ScheduleConvert {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduleConvert.class);

    public ScheduleDTO toDTO(Schedule sche) {
        logger.info("Sppp");
        ScheduleDTO scheDTO = new ScheduleDTO(sche);
        return scheDTO;
    }

    public ScheduleDTO toDTO(Schedule sche, List<String> seats) {
        ScheduleDTO scheDTO = new ScheduleDTO(sche, seats);
        return scheDTO;
    }

    public Schedule toEntity(ScheduleDTO sDto) {
        Schedule sche = new Schedule();
        sche.setPrice(sDto.getPrice());
        sche.setStartDate(LocalDate.parse(sDto.getStartDate()));
        sche.setStartTime(LocalTime.parse(sDto.getStartTime()));
        return sche;
    }

    public Schedule toEntity(ScheduleDTO sDto, Schedule sche) {
        sche.setPrice(sDto.getPrice());
        sche.setStartDate(LocalDate.parse(sDto.getStartDate()));
        sche.setStartTime(LocalTime.parse(sDto.getStartTime()));
        return sche;
    }
}
