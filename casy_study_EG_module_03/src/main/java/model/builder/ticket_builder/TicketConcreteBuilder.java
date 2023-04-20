package model.builder.ticket_builder;


import model.entity.Ticket;

import java.util.Date;

public class TicketConcreteBuilder implements ITicketBuilder {
    private long id;
    private long idUser;
    private long idSeat;
    private String userName;
    private long idMovieTheater;
    private String movieTheaterName;
    private String movieTheaterAddress;
    private long idCinema;
    private String cinemaName;
    private String movieName;
    private int movieDuration;
    private String seatCode;
    private Date showtime;
    private Date endTime;
    private int personNumber;
    private double price;

    @Override
    public ITicketBuilder id(long id) {
        this.id = id;
        return this;
    }

    @Override
    public ITicketBuilder idUser(long idUser) {
        this.idUser = idUser;
        return this;
    }

    @Override
    public ITicketBuilder idSeat(long idSeat) {
        this.idSeat = idSeat;
        return this;
    }

    @Override
    public ITicketBuilder username(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public ITicketBuilder seatCode(String seatCode) {
        this.seatCode = seatCode;
        return this;
    }

    @Override
    public ITicketBuilder capacity(int personNumber) {
        this.personNumber = personNumber;
        return this;
    }

    @Override
    public ITicketBuilder price(double price) {
        this.price = price;
        return this;
    }

    @Override
    public ITicketBuilder idMovieTheater(long idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
        return this;
    }

    @Override
    public ITicketBuilder nameOfMovieTheater(String nameOfMovieTheater) {
        this.movieTheaterName = nameOfMovieTheater;
        return this;
    }

    @Override
    public ITicketBuilder addressOfMovieTheater(String addressOfMovieTheater) {
        this.movieTheaterAddress = addressOfMovieTheater;
        return this;
    }

    @Override
    public ITicketBuilder idRoom(long idRoom) {
        this.idCinema = idRoom;
        return this;
    }

    @Override
    public ITicketBuilder nameRoom(String nameRoom) {
        this.cinemaName = nameRoom;
        return this;
    }

    @Override
    public ITicketBuilder nameMovie(String movieName) {
        this.movieName = movieName;
        return this;
    }

    @Override
    public ITicketBuilder movieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
        return this;
    }

    @Override
    public ITicketBuilder startTime(Date startTime) {
        this.showtime = startTime;
        return this;
    }

    @Override
    public ITicketBuilder endTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public Ticket build() {
        return null;
    }
}
