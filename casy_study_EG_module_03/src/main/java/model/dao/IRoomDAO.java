package model.dao;


import model.domain.room.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IRoomDAO {
    List<Room> getAll();
    List<Room> getRoomListByIdMovieTheater(long id);
    Room getRoomByIdShowtime(long idShowtime);

    Room getRoom(ResultSet resultSet) throws SQLException;
}
