package haijie.Day22.repository;

import java.util.List;

import haijie.Day22.model.Room;


public interface RoomRepo {
    int count();

    // create
    Boolean save(Room room);

    //Read all
    List<Room> findall();

    //Read one record
    Room findById(Integer id);

    //Update
    int update(Room room);

    //Delete
    int deleteById(Integer id);
}
