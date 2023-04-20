package model.service;

import model.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getAll();

    Movie getMovieById(long id);
}
