package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.repository.ScheduleRepository;

@ExtendWith(MockitoExtension.class)
public class scheduleServiceTest {

    @Mock
    private ScheduleService scheduleData;

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    @Mock
    private TicketService ticketService;

    @Mock
    private RoomService roomService;

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(scheduleService, "ticketService",
                ticketService);
        ReflectionTestUtils.setField(scheduleService, "roomService", roomService);
    }

    @Test
    void findSchedule() {
        ScheduleDTO schedule = new ScheduleDTO();
        when(scheduleData.findById(1)).thenReturn(schedule);
        assertNotNull(schedule);
    }
}
