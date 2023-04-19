package model.builder.ticket_builder;

import case_study_Enjoy_Galaxy.model.entity.Ticket;

import java.util.Date;

public interface ITicketBuilder {
    ITicketBuilder id(long id);
    ITicketBuilder idUser(long idUser);
    ITicketBuilder idSeat(long idSeat);
    ITicketBuilder seatCode(String seatCode);
    ITicketBuilder capacity(int personNumber);
    ITicketBuilder price(double price);
    ITicketBuilder username(String userName);
    ITicketBuilder idMovieTheater(long idMovieTheater);
    ITicketBuilder nameOfMovieTheater(String nameOfMovieTheater);
    ITicketBuilder addressOfMovieTheater(String addressOfMovieTheater);
    ITicketBuilder idRoom(long idRoom);
    ITicketBuilder nameRoom(String nameRoom);
    ITicketBuilder nameMovie(String movieName);
    ITicketBuilder movieDuration(int movieDuration);
    ITicketBuilder startTime(Date startTime);
    ITicketBuilder endTime(Date endTime);
    Ticket build();
}
