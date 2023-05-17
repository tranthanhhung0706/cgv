package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.ScheduleConvert;
import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Branch;
import com.example.demo.model.Movie;
import com.example.demo.model.Room;
import com.example.demo.model.Schedule;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.ScheduleRepository;

import lombok.val;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleConvert scheduleConvert;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<ScheduleDTO> getAllSchedule() {
        List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
        List<Schedule> listSchedules = scheduleRepository.findAll();
        for (Schedule schedule : listSchedules) {
            result.add(scheduleConvert.toDTO(schedule));
        }
        return result;
    }

    @Override
    public ScheduleDTO findById(Integer id) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        return scheduleConvert.toDTO(schedule);
    }

    @Override
    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        Branch branch = branchRepository.findByName(scheduleDTO.getBranchName());
        Room room = roomRepository.findByName(scheduleDTO.getRoom().getName());
        Movie movie = movieRepository.findByName(scheduleDTO.getMovieName());
        Schedule newSchedule = new Schedule();
        if (scheduleDTO.getId() == 0) {
            newSchedule = scheduleConvert.toEntity(scheduleDTO);
        } else {
            Schedule odlSchedule = scheduleRepository.findById(scheduleDTO.getId()).orElse(null);
            newSchedule = scheduleConvert.toEntity(scheduleDTO, odlSchedule);
        }
        logger.info(Integer.toString(scheduleDTO.getId()));
        newSchedule.setBranch(branch);
        newSchedule.setMovie(movie);
        newSchedule.setRoom(room);
        newSchedule = scheduleRepository.save(newSchedule);
        return scheduleConvert.toDTO(newSchedule);
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<ScheduleDTO> getSchedule(Integer idMovie, Integer idBranch) {
        List<Schedule> list = scheduleRepository.findAll();
        List<ScheduleDTO> listResult = new ArrayList<ScheduleDTO>();
        LocalDate now = LocalDate.now();
        // Lọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() != idMovie || !list.get(i).getStartDate().isAfter(now)
                    || list.get(i).getBranch().getId() != idBranch) {
                list.remove(i);
                i--;
            }
        }
        for (Schedule schedule : list) {
            listResult.add(scheduleConvert.toDTO(schedule));
        }
        return listResult;
    }

    @Override
    public List<ScheduleDTO> getSchedule(Integer idMovie) {
        List<Schedule> list = scheduleRepository.findAll();
        List<ScheduleDTO> listResult = new ArrayList<ScheduleDTO>();
        LocalDate now = LocalDate.now();
        // Lọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() != idMovie || !list.get(i).getStartDate().isAfter(now)) {
                list.remove(i);
                i--;
            }
        }
        for (Schedule schedule : list) {
            listResult.add(scheduleConvert.toDTO(schedule));
        }
        return listResult;
    }

}
