package model.dao;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Room;

import java.util.List;

public interface IRoomDAO {
    List<Room> getAll();
    List<Room> getRoomListByIdMovieTheater(long id);
}
