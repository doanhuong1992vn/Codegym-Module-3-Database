package model.entity.room.extend;


import model.entity.room.Room;

public class Room2D extends Room {
    @Override
    public double getSurcharge() {
        return 0;
    }

    public Room2D(long id, String type, String name, int rowSeat, int columnSeat, long idMovieTheater) {
        super(id, type, name, rowSeat, columnSeat, idMovieTheater);
    }

    public Room2D(String type, String name, long idMovieTheater, int columnSeat, int rowSeat) {
        super(type, name, idMovieTheater, columnSeat, rowSeat);
    }
}
