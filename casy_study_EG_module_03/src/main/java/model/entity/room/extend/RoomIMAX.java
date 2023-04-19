package model.entity.room.extend;

import model.entity.room.Room;

public class RoomIMAX extends Room {
    public RoomIMAX(long id, String type, String name, int rowSeat, int columnSeat, long idMovieTheater) {
        super(id, type, name, rowSeat, columnSeat, idMovieTheater);
    }

    public RoomIMAX(String type, String name, long idMovieTheater, int columnSeat, int rowSeat) {
        super(type, name, idMovieTheater, columnSeat, rowSeat);
    }

    @Override
    public double getSurcharge() {
        return 50000;
    }
}
