package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Room;
import com.example.demo.model.Seat;
import com.example.demo.service.RoomService;

import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
@RestController
public class RoomControllerApi {

    @Autowired
    RoomService modelService;

    @GetMapping(value = "/room")
    public RoomDTO getRoom(@RequestParam int id) {
        Room room = new Room();
        room = modelService.findById(id);
        // convert data
        RoomDTO roomDTO = new RoomDTO(room);
        Map<Integer, String> seats = new HashMap<>();
        for (Seat seat : modelService.getSeatList(room)) {
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

    @GetMapping(value = "/roomByBranch")
    public ResponseEntity<Object> findRoomByBranch(@RequestParam Integer branchId)
    {
        List<Room> rooms = modelService.findRoomByBranch(branchId);
        if (rooms == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room does not exist");
        return ResponseEntity.ok(rooms);    
    }

}
