package model.dto;

import model.domain.Showtime;
import model.domain.cinema.Cinema;
import model.domain.room.Room;

public class DomainDTO {
    private final Cinema cinema;
    private final Room room;
    private final Showtime showtime;

    public DomainDTO(Cinema cinema, Room room, Showtime showtime) {
        this.cinema = cinema;
        this.room = room;
        this.showtime = showtime;
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
}
