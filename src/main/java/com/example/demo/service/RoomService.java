package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Room;
import com.example.demo.model.Seat;

public interface RoomService {
    List<Room> findAll();

    RoomDTO findById(Integer id);

    Room save(Room e);

    Room update(Room e);

    boolean delete(Integer id);

    List<Seat> getSeatList(Room room);

    List<Room> findRoomByBranch(Integer branchId);
}
