package model.dao;


import model.domain.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface IMovieDAO {
    List<Movie> getAll();
    void insertMovie(Movie movie);

    Movie getMovieById(long id);

    Movie getMovieSimple(ResultSet resultSet) throws SQLException;
}
