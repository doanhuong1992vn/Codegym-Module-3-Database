package model.dao;


import model.entity.Showtime;

import java.util.List;

public interface IShowtimeDAO {
    void insertShowtime(Showtime showtime);
    List<Showtime> getAll();

    List<Showtime> getShowtimeListByIdRoom(long id);
}
