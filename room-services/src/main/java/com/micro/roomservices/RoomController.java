package com.micro.roomservices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
@Api(value = "rooms", description = "Data service operations on rooms", tags = ("rooms"))
public class RoomController {
    @Autowired
    private RoomRepo roomRepo;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get All Rooms", notes = "Get", nickname = "getRooms")
    public List<Room> findAll(@RequestParam(name = "roomNumber", required = false)String roomNumber){
        if(StringUtils.isNotEmpty(roomNumber)){
            return Collections.singletonList(this.roomRepo.findByRoomNumber(roomNumber));
        }
        return (List<Room>) this.roomRepo.findAll();
    }
}
