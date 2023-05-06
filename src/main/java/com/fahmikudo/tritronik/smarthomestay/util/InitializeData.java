package com.fahmikudo.tritronik.smarthomestay.util;

import com.fahmikudo.tritronik.smarthomestay.entity.AdditionalFacilities;
import com.fahmikudo.tritronik.smarthomestay.entity.Room;
import com.fahmikudo.tritronik.smarthomestay.repository.AdditionalFacilitiesRepository;
import com.fahmikudo.tritronik.smarthomestay.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InitializeData {

    private final RoomRepository roomRepository;
    private final AdditionalFacilitiesRepository additionalFacilitiesRepository;

    @PostConstruct
    private void initializeRoom() {
        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            room.setRoomName(UUID.randomUUID().toString());
            room.setRoomType(UUID.randomUUID().toString());
            room.setPrice(new BigDecimal(1000000));
            room.setLatitude(0D);
            room.setLongitude(0D);
            roomRepository.save(room);
        }
    }

    @PostConstruct
    private void initializeAdditionalFacilities() {
        for (int i = 0; i < 5; i++) {
            AdditionalFacilities additionalFacilities = new AdditionalFacilities();
            additionalFacilities.setFacilityName(UUID.randomUUID().toString());
            additionalFacilities.setFacilityType(UUID.randomUUID().toString());
            additionalFacilities.setPrice(new BigDecimal(100000));
            additionalFacilitiesRepository.save(additionalFacilities);
        }

    }

}
