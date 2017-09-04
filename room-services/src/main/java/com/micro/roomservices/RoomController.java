package com.micro.roomservices;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {
    @Autowired
    private RoomRepo roomRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Room> findAll(@RequestParam(name = "roomNumber", required = false)String roomNumber){
        if(StringUtils.isNotEmpty(roomNumber)){
            return Collections.singletonList(this.roomRepo.findByRoomNumber(roomNumber));
        }
        return (List<Room>) this.roomRepo.findAll();
    }
}
