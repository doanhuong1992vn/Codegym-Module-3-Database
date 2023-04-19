package model.entity.cinema.extend;


import model.entity.cinema.MovieTheater;

public class StandardMovieTheater extends MovieTheater {
    public StandardMovieTheater(String name, String address) {
        super(name, address);
    }

    public StandardMovieTheater(long id, String type, String name, String address) {
        super(id, type, name, address);
    }

    @Override
    public double getSurcharge() {
        return 0;
    }
}
