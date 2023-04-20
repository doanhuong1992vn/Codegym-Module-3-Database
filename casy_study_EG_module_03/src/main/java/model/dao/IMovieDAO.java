package model.dao;


import model.entity.Movie;

import java.util.List;

public interface IMovieDAO {
    List<Movie> getAll();
    void insertMovie(Movie movie);

    Movie getMovieById(long id);
}
