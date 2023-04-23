package model.domain.cinema.extend;


import model.domain.cinema.Cinema;

public class StandardCinema extends Cinema {
    public StandardCinema(String name, String address) {
        super(name, address);
    }

    public StandardCinema(long id, String type, String name, String address) {
        super(id, type, name, address);
    }

    @Override
    public double getSurcharge() {
        return 0;
    }
}
