package model.dao;


import model.entity.room.Room;

import java.util.List;

public interface IRoomDAO {
    List<Room> getAll();
    List<Room> getRoomListByIdMovieTheater(long id);
    Room getRoomByIdShowtime(long idShowtime);
}
