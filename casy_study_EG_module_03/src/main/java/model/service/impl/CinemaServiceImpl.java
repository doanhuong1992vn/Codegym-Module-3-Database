package model.service.impl;

import model.dao.iplm.ShowtimeDAO;
import model.entity.Showtime;
import model.service.ICinemaService;

import java.util.*;

public class CinemaServiceImpl implements ICinemaService {
    public static ICinemaService getCinemaService() {
        return new CinemaServiceImpl();
    }

    @Override
    public Map<String, Set<Showtime>> getMapShowtime(long idMovie, Date date) {
        return ShowtimeDAO.getShowtimeDAO().getMap(idMovie, date);
    }
}
