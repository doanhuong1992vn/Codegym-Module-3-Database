package model.builder.showtime_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.Date;

public interface IShowtimeBuilder {
    IShowtimeBuilder id(long id);
    IShowtimeBuilder idMovieTheater(long idMovieTheater);
    IShowtimeBuilder idRoom(long idCinema);
    IShowtimeBuilder nameMovieTheater(String nameMovieTheater);
    IShowtimeBuilder addressMovieTheater(String addressMovieTheater);
    IShowtimeBuilder nameRoom(String nameRoom);
    IShowtimeBuilder startTime(Date startTime);
    IShowtimeBuilder endTime(Date endTime);
    IShowtimeBuilder movie(Movie movie);
    IShowtimeBuilder price(double price);
    Showtime build();
}
