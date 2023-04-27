package model.service.impl;

import model.dao.iplm.MovieDAO;
import model.domain.Movie;
import model.service.IMovieService;
import model.utils.Converter;

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
        int count = movies.size();
        int randomIndex = (int) Math.floor(Math.random() * count);
        return movies.get(randomIndex);
    }

    @Override
    public List<Movie> getMoviesBySearch(String search) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : getAll()) {
            String strMovie = Converter.removeAccent(movie.toString()).toUpperCase();
            String keyword = Converter.removeAccent(search).toUpperCase();
            if (strMovie.contains(keyword)) {
                movies.add(movie);
            }
        }
        return movies;
    }
}
