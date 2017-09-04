package com.micro.roomservices;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
    Room findByRoomNumber(String roomNumber);
}
