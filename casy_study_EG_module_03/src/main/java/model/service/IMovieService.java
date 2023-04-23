package model.service;

import model.domain.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getAll();

    Movie getMovieById(long id);

    Movie getRandomMovie();

    List<Movie> getMoviesBySearch(String search);
}
