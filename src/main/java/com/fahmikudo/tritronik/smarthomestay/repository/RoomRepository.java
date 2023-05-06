package com.fahmikudo.tritronik.smarthomestay.repository;

import com.fahmikudo.tritronik.smarthomestay.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends BaseRepository<Room> {

    Page<Room> findAll(Pageable pageable);

    Page<Room> findByRoomNameContaining(Pageable pageable, String roomName);

}
