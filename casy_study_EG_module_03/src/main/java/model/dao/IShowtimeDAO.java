package model.dao;

import case_study_Enjoy_Galaxy.model.entity.Showtime;

import java.util.List;

public interface IShowtimeDAO {
    void insertShowtime(Showtime showtime);
    List<Showtime> getAll();

    List<Showtime> getShowtimeListByIdRoom(long id);
}
