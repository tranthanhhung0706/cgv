package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Room findById(Integer id) {
        // TODO Auto-generated method stub
        return roomRepository.findById(id).orElse(null);
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

}
