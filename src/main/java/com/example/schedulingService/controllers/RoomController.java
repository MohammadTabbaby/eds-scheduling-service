package com.example.schedulingService.controllers;

import com.example.schedulingService.entities.RoomEntity;
import com.example.schedulingService.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomEntity> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping
    public RoomEntity saveRoom(@RequestBody RoomEntity roomEntity) {
        return roomService.saveRoom(roomEntity);
    }
}

