package model.dto;

import model.domain.Movie;
import model.domain.Showtime;
import model.domain.Ticket;
import model.domain.cinema.Cinema;
import model.domain.room.Room;
import model.domain.seat.Seat;

public class DomainDTO implements Cloneable{
    private Cinema cinema;
    private Room room;
    private Showtime showtime;
    private Seat seat;
    private Ticket ticket;
    private Movie movie;

    public DomainDTO(Cinema cinema, Room room, Showtime showtime) {
        this.cinema = cinema;
        this.room = room;
        this.showtime = showtime;
    }

    public DomainDTO(Cinema cinema, Room room, Showtime showtime, Seat seat, Ticket ticket, Movie movie) {
        this.cinema = cinema;
        this.room = room;
        this.showtime = showtime;
        this.seat = seat;
        this.ticket = ticket;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Room getRoom() {
        return room;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public DomainDTO clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (DomainDTO) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
