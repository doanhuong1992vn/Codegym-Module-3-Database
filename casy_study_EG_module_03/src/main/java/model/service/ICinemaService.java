package model.service;

import model.entity.Movie;
import model.entity.Showtime;
import model.entity.cinema.Cinema;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ICinemaService {

    Map<String, Set<Showtime>> getMapShowtime(long idMovie, Date date);
}
