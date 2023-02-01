package haijie.Day22.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haijie.Day22.model.Room;
import haijie.Day22.repository.RoomRepo;


@Service
public class RoomService{

    @Autowired
    RoomRepo roomRepo; //access through the interface not the actual class

    public int count() {
        return roomRepo.count();
    }

    public Boolean save(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> findall() {
        return roomRepo.findall();
    }

    public Room findById(Integer id) {
        return roomRepo.findById(id);
    }

    public int update(Room room) {
        return roomRepo.update(room);
    }

    public int deleteById(Integer id) {
        return roomRepo.deleteById(id);
    }


}
