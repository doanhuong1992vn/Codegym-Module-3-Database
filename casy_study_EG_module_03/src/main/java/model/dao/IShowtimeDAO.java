package model.dao;


import model.entity.Movie;
import model.entity.Showtime;
import model.entity.cinema.Cinema;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IShowtimeDAO {
    void insertShowtime(Showtime showtime);
    List<Showtime> getAll();

    List<Showtime> getShowtimeList(long id, String type);

    Map<String, Set<Showtime>> getMap(long id, Date date);
}
