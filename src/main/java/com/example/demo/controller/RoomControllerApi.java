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
    RoomService roomService;

    @GetMapping(value = "/room")
    public RoomDTO getRoom(@RequestParam int id) {

        return roomService.findById(id);
    }

    @GetMapping(value = "/roomByBranch")
    public ResponseEntity<Object> findRoomByBranch(@RequestParam Integer branchId) {
        List<Room> rooms = roomService.findRoomByBranch(branchId);
        if (rooms == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room does not exist");
        return ResponseEntity.ok(rooms);
    }

}
