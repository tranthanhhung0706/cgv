package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
