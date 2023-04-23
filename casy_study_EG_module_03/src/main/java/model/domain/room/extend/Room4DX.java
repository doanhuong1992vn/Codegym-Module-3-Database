package model.domain.room.extend;

import model.domain.room.Room;

public class Room4DX extends Room {
    public Room4DX(long id, String type, String name, int rowSeat, int columnSeat, long idMovieTheater) {
        super(id, type, name, rowSeat, columnSeat, idMovieTheater);
    }

    public Room4DX(String type, String name, long idMovieTheater, int columnSeat, int rowSeat) {
        super(type, name, idMovieTheater, columnSeat, rowSeat);
    }

    @Override
    public double getSurcharge() {
        return 30000;
    }
}
