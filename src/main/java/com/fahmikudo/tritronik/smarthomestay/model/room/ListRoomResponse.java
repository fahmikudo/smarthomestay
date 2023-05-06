package com.fahmikudo.tritronik.smarthomestay.model.room;

import com.fahmikudo.tritronik.smarthomestay.util.PageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListRoomResponse {

    private PageResponse page;
    private List<RoomResponse> rooms;

}
