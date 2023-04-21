package model.factory;


import model.entity.cinema.Cinema;
import model.entity.cinema.extend.StandardCinema;

public class CinemaFactory {
    private static final CinemaFactory CINEMA_FACTORY = new CinemaFactory();
    private CinemaFactory() {
    }
    public static CinemaFactory getInstance() {
        return CINEMA_FACTORY;
    }

    public Cinema getCinema(long id, String type, String name, String address) {
        if (type.equalsIgnoreCase("STANDARD")) {
            return new StandardCinema(id, type, name, address);
        }
        return null;
    }
}
