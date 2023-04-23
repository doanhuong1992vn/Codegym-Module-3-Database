package model.dao;


import model.domain.Movie;

import java.util.List;

public interface IMovieDAO {
    List<Movie> getAll();
    void insertMovie(Movie movie);

    Movie getMovieById(long id);
}
