package model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
    private long id;
    private String name;
    private String director;
    private String actors;
    private String genre;
    private Date premiereDate;
    private int duration;
    private String language;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Movie(String name, String director, String actors, String genre, Date premiereDate, int duration, String language, String content) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.genre = genre;
        this.premiereDate = premiereDate;
        this.duration = duration;
        this.language = language;
        this.content = content;
    }

    public Movie(long id, String name, String director, String actors, String genre, Date premiereDate, int duration, String language, String content) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.genre = genre;
        this.premiereDate = premiereDate;
        this.duration = duration;
        this.language = language;
        this.content = content;
    }
}
