package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Room;
import com.example.demo.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findAllByRoom(Room room);

    // remake data from seat table
    @Query("SELECT s FROM Seat s WHERE s.room.id=:roomId and s.name=:seatName")
    List<Seat> findSeatByRoomIdAndSeatName(@Param("roomId") Integer roomId,
            @Param("seatName") String seatName);

    @Query("SELECT s FROM Seat s WHERE s.room.id = :roomId")
    List<Seat> findSeatsByRoom(@Param("roomId") Integer roomId);

    @Query("SELECT s FROM Seat s JOIN Ticket t ON s.id = t.seat.id WHERE t.schedule.id = :scheduleId")
    List<Seat> findSeatsIsOccupiedBySchedule(@Param("scheduleId") Integer scheduleId);


}
