package model.service;

import model.domain.Showtime;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface IShowtimeService {

    Map<String, Set<Showtime>> getMapShowtime(long idMovie, Date date) throws ParseException;

    int getNumberShowtime(Map<String, Set<Showtime>> mapShowtime);
}
