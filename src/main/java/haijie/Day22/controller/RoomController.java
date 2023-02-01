package haijie.Day22.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import haijie.Day22.model.Room;
import haijie.Day22.service.RoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("/api/rooms")
@RestController
public class RoomController {
    
    @Autowired
    RoomService roomService;

    @GetMapping("/count")
    public Integer getRoomCount(){
        Integer roomCount=roomService.count();
        return roomCount;
    }

    @GetMapping("/")
    public ResponseEntity<List<Room>> retrieveAllRooms(){
        List<Room> rooms= new ArrayList<Room>();
        rooms=roomService.findall();

        if(rooms.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rooms,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Room> retrieveRoomById(@PathVariable("id") int id){
        
        Room room=roomService.findById(id);

        if (room==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(room,HttpStatus.OK);
        }
    }

    @PostMapping(value="/create")
    public ResponseEntity<Boolean> createRooom(@RequestBody Room room){
        Room rm=room;
        Boolean result=roomService.save(rm);

        if(result){
            return new ResponseEntity<Boolean>(result,HttpStatus.CREATED);
        }
        else{
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/put")
    public ResponseEntity<Integer> updateRoom(@RequestBody Room room){
        Room rm = room;
        int updated = roomService.update(rm);

        if(updated==1){
            return new ResponseEntity<>(1, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteRoom(@PathVariable("id") int id){
        int deleteResult=0;
        deleteResult=roomService.deleteById(id);

        if(deleteResult==0){
            return new ResponseEntity<>(0,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(1, HttpStatus.OK);
        }
    }
    
}
