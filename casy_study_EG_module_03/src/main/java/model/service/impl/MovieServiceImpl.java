package model.service.impl;

import model.dao.iplm.MovieDAO;
import model.domain.Movie;
import model.service.IMovieService;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements IMovieService {
    public static IMovieService getMovieService() {
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

    @Override
    public Movie getRandomMovie() {
        List<Movie> movies = getAll();
        int count = movies.size() - 1;
        int randomIndex = (int) Math.ceil(Math.random() * count);
        return movies.get(randomIndex);
    }

    @Override
    public List<Movie> getMoviesBySearch(String search) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : getAll()) {
            if (movie.toString().contains(search.toUpperCase())) {
                movies.add(movie);
            }
        }
        return movies;
    }
}
