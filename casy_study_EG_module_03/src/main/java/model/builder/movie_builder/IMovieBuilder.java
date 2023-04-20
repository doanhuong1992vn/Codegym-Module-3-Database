package model.builder.movie_builder;


import model.entity.Movie;

import java.text.ParseException;
import java.util.Date;

public interface IMovieBuilder {
    IMovieBuilder id(long id);
    IMovieBuilder name(String name);
    IMovieBuilder director(String director);
    IMovieBuilder actors(String actors);
    IMovieBuilder genre(String genre);
    IMovieBuilder premiereDate(Date premiereDate) throws ParseException;
    IMovieBuilder duration(int duration);
    IMovieBuilder language(String language);
    IMovieBuilder content(String content);
    IMovieBuilder urlImage(String urlImage);
    Movie build() throws ParseException;
    Movie buildFull() throws ParseException;
}
