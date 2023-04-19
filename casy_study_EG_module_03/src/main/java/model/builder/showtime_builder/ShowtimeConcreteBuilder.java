package model.builder.showtime_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.Date;

public class ShowtimeConcreteBuilder implements IShowtimeBuilder {
    private long id;
    private long idMovieTheater;
    private long idRoom;
    private String nameMovieTheater;
    private String addressMovieTheater;
    private String nameRoom;
    private Date startTime;
    private Date endTime;
    private Movie movie;
    private double price;

    @Override
    public IShowtimeBuilder id(long id) {
        this.id = id;
        return this;
    }

    @Override
    public IShowtimeBuilder idMovieTheater(long idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
        return this;
    }

    @Override
    public IShowtimeBuilder idRoom(long idRoom) {
        this.idRoom = idRoom;
        return this;
    }

    @Override
    public IShowtimeBuilder nameMovieTheater(String nameMovieTheater) {
        this.nameMovieTheater = nameMovieTheater;
        return this;
    }

    @Override
    public IShowtimeBuilder addressMovieTheater(String addressMovieTheater) {
        this.addressMovieTheater = addressMovieTheater;
        return this;
    }

    @Override
    public IShowtimeBuilder nameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
        return this;
    }

    @Override
    public IShowtimeBuilder startTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    @Override
    public IShowtimeBuilder endTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public IShowtimeBuilder movie(Movie movie) {
        this.movie = movie;
        return this;
    }

    @Override
    public IShowtimeBuilder price(double price) {
        this.price = price;
        return this;
    }

    @Override
    public Showtime build() {
        return new Showtime(
                id,
                idMovieTheater,
                idRoom,
                nameMovieTheater,
                addressMovieTheater,
                nameRoom,
                startTime,
                endTime,
                movie,
                price);
    }
}
