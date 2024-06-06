package com.example.schedulingService.services;

import com.example.schedulingService.entities.RoomEntity;
import com.example.schedulingService.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    public RoomEntity saveRoom(RoomEntity roomEntity) {
        return roomRepository.save(roomEntity);
    }
}
