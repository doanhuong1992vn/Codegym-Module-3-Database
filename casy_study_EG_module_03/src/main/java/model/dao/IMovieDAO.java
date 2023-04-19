package model.dao;

import case_study_Enjoy_Galaxy.model.entity.Movie;

import java.util.List;

public interface IMovieDAO {
    List<Movie> getAll();
    void insertMovie(Movie movie);
}
