package com.example.demo.convert;

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
    
    public Schedule toEntity(ScheduleDTO sDto)
    {
    	Schedule sche = new Schedule();
    	//System.out.println(sDto.getPrice());
    	sche.setPrice(sDto.getPrice());
    	sche.setStartDate(sDto.getStartDate());
    	sche.setStartTime(sDto.getStartTime());
    	return sche;
    }
    
    public Schedule toEntity(ScheduleDTO sDto, Schedule sche)
    {
    	sche.setPrice(sDto.getPrice());
    	sche.setStartDate(sDto.getStartDate());
    	sche.setStartTime(sDto.getStartTime());
    	return sche;
    }
}
