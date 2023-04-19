package model.factory;


import model.entity.room.Room;
import model.entity.room.extend.Room2D;
import model.entity.room.extend.Room3D;
import model.entity.room.extend.Room4DX;
import model.entity.room.extend.RoomIMAX;

public class RoomFactory {
    private static final RoomFactory roomFactory = new RoomFactory();
    private RoomFactory(){
    }
    public static RoomFactory getInstance() {
        return roomFactory;
    }
    public Room getRoom(long id, String type, String name, int numberRowSeat, int numberColumnSeat, long idMovieTheater) {
        String typeUP = type.toUpperCase();
        switch (typeUP) {
            case "2D" -> {
                return new Room2D(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            case "3D" -> {
                return new Room3D(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            case "4DX" -> {
                return new Room4DX(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            case "IMAX" -> {
                return new RoomIMAX(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            default -> {
                return null;
            }
        }
    }
}
