package model.builder.showtime_builder;



import model.domain.Showtime;

import java.util.Date;

public interface IShowtimeBuilder {
    IShowtimeBuilder id(long id);
    IShowtimeBuilder idRoom(long idCinema);
    IShowtimeBuilder startTime(Date startTime);
    IShowtimeBuilder endTime(Date endTime);
    IShowtimeBuilder idMovie(long idMovie);
    IShowtimeBuilder price(double price);
    Showtime build(String type);
}
