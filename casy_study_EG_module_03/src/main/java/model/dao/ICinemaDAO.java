package model.dao;


import model.entity.cinema.Cinema;

import java.util.List;

public interface ICinemaDAO {
    void insertMovieTheater(Cinema cinema);
    List<Cinema> getAll();
}
