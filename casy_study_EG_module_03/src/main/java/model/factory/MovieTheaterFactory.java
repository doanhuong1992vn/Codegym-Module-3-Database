package model.factory;

import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.StandardMovieTheater;

public class MovieTheaterFactory {
    private static final MovieTheaterFactory movieTheaterFactory = new MovieTheaterFactory();
    private MovieTheaterFactory() {
    }
    public static MovieTheaterFactory getInstance() {
        return movieTheaterFactory;
    }

    public MovieTheater getMovieTheater(long id, String type, String name, String address) {
        if (type.equalsIgnoreCase("STANDARD")) {
            return new StandardMovieTheater(id, type, name, address);
        }
        return null;
    }
}
