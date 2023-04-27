package model.domain;

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
    private String urlImage;

    public Movie(String name, String urlImage) {
        this.name = name;
        this.urlImage = urlImage;
    }

    public Movie(String name,
                 String director,
                 String actors,
                 String genre,
                 Date premiereDate,
                 int duration,
                 String language,
                 String content,
                 String urlImage) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.genre = genre;
        this.premiereDate = premiereDate;
        this.duration = duration;
        this.language = language;
        this.content = content;
        this.urlImage = urlImage;
    }

    public Movie(long id,
                 String name,
                 String director,
                 String actors,
                 String genre,
                 Date premiereDate,
                 int duration,
                 String language,
                 String content,
                 String urlImage) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.genre = genre;
        this.premiereDate = premiereDate;
        this.duration = duration;
        this.language = language;
        this.content = content;
        this.urlImage = urlImage;
    }

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

    public String getPremiereDateFormat() {
        return new SimpleDateFormat("dd MMMM yyyy").format(getPremiereDate());
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return String
                .format
                ("Phim %s đạo diễn %s diễn viên %s thể loại %s khởi chiếu ngày %s thời lượng %d ngôn ngữ %s nội dung %s",
                getName(), getDirector(), getActors(), getGenre(),
                new SimpleDateFormat("dd/MM/yyyy").format(getPremiereDate()),
                getDuration(), getLanguage(), getContent()).toUpperCase();
    }
}
