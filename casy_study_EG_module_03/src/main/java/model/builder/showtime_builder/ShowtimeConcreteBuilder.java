package model.builder.showtime_builder;


import model.entity.Movie;
import model.entity.Showtime;

import java.util.Date;

public class ShowtimeConcreteBuilder implements IShowtimeBuilder {
    private long id;
    private long idRoom;
    private Date startTime;
    private Date endTime;
    private long idMovie;
    private double price;

    @Override
    public IShowtimeBuilder id(long id) {
        this.id = id;
        return this;
    }

    @Override
    public IShowtimeBuilder idRoom(long idRoom) {
        this.idRoom = idRoom;
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
    public IShowtimeBuilder idMovie(long idMovie) {
        this.idMovie = idMovie;
        return this;
    }

    @Override
    public IShowtimeBuilder price(double price) {
        this.price = price;
        return this;
    }

    @Override
    public Showtime build(String type) {
        if (type.equalsIgnoreCase("full")) {
            return new Showtime(id, startTime, endTime, idRoom, idMovie);
        } else if (type.equalsIgnoreCase("demo")) {
            return new Showtime(startTime, endTime, idRoom, idMovie);
        }
        return null;
    }

}
