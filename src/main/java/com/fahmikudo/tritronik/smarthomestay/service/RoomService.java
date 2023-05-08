package com.fahmikudo.tritronik.smarthomestay.service;

import com.fahmikudo.tritronik.smarthomestay.entity.Room;
import com.fahmikudo.tritronik.smarthomestay.model.room.ListRoomResponse;
import com.fahmikudo.tritronik.smarthomestay.model.room.RoomResponse;
import com.fahmikudo.tritronik.smarthomestay.repository.RoomRepository;
import com.fahmikudo.tritronik.smarthomestay.util.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public ListRoomResponse getAllRoom(int size, int page, String keyword) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("createdAt").descending());
        Page<Room> rooms;
        if (keyword != null) {
            rooms = roomRepository.findByRoomNameContaining(pageable, keyword);
        } else {
            rooms = roomRepository.findAll(pageable);
        }
        PageResponse pageResponse = new PageResponse(rooms.getTotalElements(),
                rooms.getTotalPages(), size, page);

        if (rooms.isEmpty()) {
            return new ListRoomResponse(pageResponse, new ArrayList<>());
        }

        List<RoomResponse> roomResponses = new ArrayList<>();
        for (Room room : rooms) {
            RoomResponse roomResponse = RoomResponse.builder()
                    .id(room.getId())
                    .roomName(room.getRoomName())
                    .roomType(room.getRoomType())
                    .price(room.getPrice())
                    .latitude(room.getLatitude())
                    .longitude(room.getLongitude())
                    .build();
            roomResponses.add(roomResponse);
        }

        return ListRoomResponse.builder()
                .page(pageResponse)
                .rooms(roomResponses)
                .build();

    }


}
