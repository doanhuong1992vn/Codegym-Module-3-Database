package model.service.impl;

import model.dao.iplm.MovieDAO;
import model.entity.Movie;
import model.service.IMovieService;

import java.util.List;

public class MovieServiceImpl implements IMovieService {
    public static IMovieService getInstance(){
        return new MovieServiceImpl();
    }
    @Override
    public List<Movie> getAll() {
        return MovieDAO.getMovieDAO().getAll();
    }

    @Override
    public Movie getMovieById(long id) {
        return MovieDAO.getMovieDAO().getMovieById(id);
    }
}
