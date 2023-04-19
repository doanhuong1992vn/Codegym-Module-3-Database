package model.builder.movie_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;

import java.text.ParseException;
import java.util.Date;

public interface IMovieBuilder {
    IMovieBuilder id(long id);
    IMovieBuilder setName(String name);
    IMovieBuilder setDirector(String director);
    IMovieBuilder setActors(String actors);
    IMovieBuilder setMovieGenre(String movieGenre);
    IMovieBuilder setStrPremiereDate(String premiereDate) throws ParseException;
    IMovieBuilder setPremiereDate(Date premiereDate) throws ParseException;
    IMovieBuilder setMovieDuration(int movieDuration);
    IMovieBuilder setLanguage(String language);
    IMovieBuilder setContent(String content);
    Movie build() throws ParseException;
    Movie buildFull() throws ParseException;
}
