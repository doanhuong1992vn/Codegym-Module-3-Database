package model.service.impl;

import model.dao.iplm.RoomDAO;
import model.dao.iplm.SeatDAO;
import model.entity.room.Room;
import model.entity.seat.Seat;
import model.service.ISeatService;

import java.util.List;

public class SeatServiceImpl implements ISeatService {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static ISeatService getSeatService(){
        return new SeatServiceImpl();
    }

    @Override
    public Seat[][] getSeatsByIdShowtime(long idShowtime) {
        List<Seat> seatList = SeatDAO.getSeatDAO().getSeatsByIdShowtime(idShowtime);
        Room room = RoomDAO.getRoomDAO().getRoomByIdShowtime(idShowtime);
        Seat[][] seats = new Seat[room.getRowSeat()][room.getColumnSeat()];
        for (Seat seat : seatList) {
            int indexRow = alphabet.indexOf(seat.getCode().charAt(0));
            int indexColumn = Integer.parseInt(seat.getCode().substring(1)) - 1;
            seats[indexRow][indexColumn] = seat;
        }
        return seats;
    }
}
