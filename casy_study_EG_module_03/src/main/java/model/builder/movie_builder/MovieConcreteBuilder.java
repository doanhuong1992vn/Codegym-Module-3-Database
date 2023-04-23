package model.builder.movie_builder;


import model.domain.Movie;

import java.text.ParseException;
import java.util.Date;

public class MovieConcreteBuilder implements IMovieBuilder{
    private long id;
    private String name;
    private String director;
    private String actors;
    private String movieGenre;
    private Date premiereDate;
    private int movieDuration;
    private String language;
    private String content;
    private String urlImage;

    @Override
    public IMovieBuilder id(long id) {
        this.id = id;
        return  this;
    }

    @Override
    public IMovieBuilder premiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
        return this;
    }

    @Override
    public IMovieBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IMovieBuilder director(String director) {
        this.director = director;
        return this;
    }

    @Override
    public IMovieBuilder actors(String actors) {
        this.actors = actors;
        return this;
    }

    @Override
    public IMovieBuilder genre(String genre) {
        this.movieGenre = genre;
        return this;
    }

    @Override
    public IMovieBuilder duration(int duration) {
        this.movieDuration = duration;
        return this;
    }

    @Override
    public IMovieBuilder language(String language) {
        this.language = language;
        return this;
    }

    @Override
    public IMovieBuilder content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public IMovieBuilder urlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }

    @Override
    public Movie build() throws ParseException {
        return new Movie(name, director, actors, movieGenre,
                premiereDate, movieDuration, language, content, urlImage);
    }

    @Override
    public Movie buildFull() throws ParseException {
        return new Movie(id, name, director, actors, movieGenre,
                premiereDate, movieDuration, language, content, urlImage);
    }
}
