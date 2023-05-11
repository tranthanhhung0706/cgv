package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Room;
import com.example.demo.model.Seat;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.SeatRepository;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    SeatRepository seatRepository;

    @Override
    public List<Seat> getSeatList(Room room) {
        // TODO Auto-generated method stub
        return seatRepository.findAllByRoom(room);
    }

    @Override
    public List<Room> findAll() {
        // TODO Auto-generated method stub
        return roomRepository.findAll();
    }

    @Override
    public RoomDTO findById(Integer id) {
        // TODO Auto-generated method stub
        Room room = roomRepository.findById(id).orElse(null);
        RoomDTO roomDTO = new RoomDTO(room);
        Map<Integer, String> seats = new HashMap<>();
        for (Seat seat : seatRepository.findAllByRoom(room)) {
            seats.put(seat.getId(), seat.getName());
        }
        roomDTO.setSeatList(sortByValue(seats));
        return roomDTO;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    @Override
    public Room save(Room e) {
        // TODO Auto-generated method stub
        Room room = null;
        try {
            room = roomRepository.save(e);
        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Error save room! " + ex.getLocalizedMessage());
        }
        return room;
    }

    @Override
    public Room update(Room e) {
        // TODO Auto-generated method stub
        try {
            return roomRepository.save(e);
        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Error update room!!" + ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        try {
            roomRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error delete room!! " + e.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public List<Room> findRoomByBranch(Integer branchId) {
        return roomRepository.findRoomByBranch(branchId);
    }

    
}
