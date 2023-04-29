package model.service.impl;

import model.dao.iplm.RoomDAO;
import model.dao.iplm.SeatDAO;
import model.domain.room.Room;
import model.domain.seat.Seat;
import model.factory.SeatFactory;
import model.service.ISeatService;

import java.util.List;

public class SeatServiceImpl implements ISeatService {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static ISeatService getSeatService() {
        return new SeatServiceImpl();
    }

    @Override
    public Seat[][] getSeatArrayByIdShowtime(long idShowtime) {
        Room room = RoomDAO.getRoomDAO().getRoomByIdShowtime(idShowtime);
        List<Seat> seatList = getSeatListByIdShowtime(idShowtime, room);
        Seat[][] seats = new Seat[room.getRowSeat()][room.getColumnSeat()];
        for (Seat seat : seatList) {
            int indexRow = ALPHABET.indexOf(seat.getCode().charAt(0));
            int indexColumn = Integer.parseInt(seat.getCode().substring(1)) - 1;
            seats[indexRow][indexColumn] = seat;
        }
        return seats;
    }

    private List<Seat> getSeatListByIdShowtime(long idShowtime, Room room) {
        List<Seat> seatList;
        do {
            seatList = SeatDAO.getSeatDAO().getSeatsByIdShowtime(idShowtime);
            if (seatList.isEmpty()) {
                getSeatsAndInsert(idShowtime, room);
            }
        } while (seatList.isEmpty());
        return seatList;
    }

    public static void getSeatsAndInsert(long idShowtime, Room room) {
        Seat[][] seats = SeatFactory.getInstance().getSeats(
                room.getRowSeat(),
                room.getColumnSeat(),
                idShowtime);
        for (Seat[] rowSeat : seats) {
            for (Seat seat : rowSeat) {
                seat.setPrice(seat.getSurcharge() + room.getSurcharge());
                SeatDAO.getSeatDAO().insertSeat(seat);
            }
        }
    }
}
