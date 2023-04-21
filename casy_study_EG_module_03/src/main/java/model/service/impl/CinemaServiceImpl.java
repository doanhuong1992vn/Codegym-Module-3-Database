package model.service.impl;

import model.dao.iplm.RoomDAO;
import model.dao.iplm.ShowtimeDAO;
import model.entity.Movie;
import model.entity.Showtime;
import model.entity.cinema.Cinema;
import model.entity.room.Room;
import model.service.ICinemaService;
import model.utils.Converter;

import java.util.*;

public class CinemaServiceImpl implements ICinemaService {
    public static ICinemaService getInstance() {
        return new CinemaServiceImpl();
    }

    @Override
    public Map<String, Set<Showtime>> getMapShowtime(long idMovie, Date date) {
        return ShowtimeDAO.getShowtimeDAO().getMap(idMovie, date);
    }
}
