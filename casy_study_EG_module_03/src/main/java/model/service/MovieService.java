package model.service;

import case_study_Enjoy_Galaxy.model.dao.iplm.MovieDAO;
import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.utils.Converter;
import case_study_Enjoy_Galaxy.model.utils.FileReaderUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private static final MovieService movieService = new MovieService();
    private static final List<Movie> movieList = new ArrayList<>();

    static {
        movieList.addAll(MovieDAO.getMovieDAO().getAll());
    }

    private MovieService() {
    }

    public static MovieService getInstance() {
        return movieService;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public List<Movie> getMovieListSortedByShortestMovieDuration() {
        movieList.sort(Comparator.comparingLong(Movie::getMovieDuration));
        return movieList;
    }
    public List<Movie> getMovieListSortedByLongestMovieDuration() {
        movieList.sort(Comparator.comparingLong(Movie::getMovieDuration).reversed());
        return movieList;
    }
    public List<Movie> getMovieListSortedByOldestMovie() {
        movieList.sort(Comparator.comparingLong(Movie::getTimeOfPremiereDate));
        return movieList;
    }
    public List<Movie> getMovieListSortedByLatestMovie() {
        movieList.sort(Comparator.comparingLong(Movie::getTimeOfPremiereDate).reversed());
        return movieList;
    }

    public List<Movie> getMovieListByKeyword(String keyword) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieList) {
            String movieTitleConverted = Converter.removeAccent(movie.getName());
            String keywordConverted = Converter.removeAccent(keyword);
            if (movieTitleConverted.contains(keywordConverted)) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public Movie getMovieById(long idMovie) {
        for (Movie movie : movieList) {
            if (movie.getId() == idMovie) {
                return movie;
            }
        }
        return null;
    }

    public Movie getRandomMovie() {
        int numberOfMovie = movieList.size();
        int idMovieRandom = (int) Math.ceil(Math.random() * numberOfMovie);
        return getMovieById(idMovieRandom);
    }
}
