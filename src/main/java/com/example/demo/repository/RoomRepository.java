package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Room;



public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r WHERE r.branch.id = :branchId ")
    List<Room> findRoomByBranch(@Param("branchId") Integer branchId);
}
