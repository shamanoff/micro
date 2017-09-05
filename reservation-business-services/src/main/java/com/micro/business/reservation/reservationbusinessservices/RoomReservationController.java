package com.micro.business.reservation.reservationbusinessservices;

import com.micro.business.reservation.reservationbusinessservices.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
public class RoomReservationController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getAllRooms(){
        ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange(
                "http://ROOMSERVICES/rooms", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Room>>() {
                });
        return roomResponse.getBody();
    }

}
