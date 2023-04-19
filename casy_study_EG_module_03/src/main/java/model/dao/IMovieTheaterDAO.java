package model.dao;

import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;

import java.util.List;

public interface IMovieTheaterDAO {
    void insertMovieTheater(MovieTheater movieTheater);
    List<MovieTheater> getAll();
}
