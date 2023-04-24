package model.factory;


import model.domain.seat.Seat;
import model.domain.seat.extend.DeluxeSeat;
import model.domain.seat.extend.StandardSeat;
import model.domain.seat.extend.SweetBox;
import model.domain.seat.extend.VipSeat;

public class SeatFactory {
    private static final String[] alphabet =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
    private static final SeatFactory seatFactory = new SeatFactory();
    private SeatFactory(){
    }
    public static SeatFactory getInstance() {
        return seatFactory;
    }

    public Seat getSeat(long id, String type, String code, boolean ready, long idShowtime, double price) {
        String typeUP = type.toUpperCase();
        switch (typeUP) {
            case "SWEETBOX" -> {
                return new SweetBox(id, type, code, ready, idShowtime, price);
            }
            case "DELUXESEAT" -> {
                return new DeluxeSeat(id, type, code, ready, idShowtime, price);
            }
            case "VIPSEAT" -> {
                return new VipSeat(id, type, code, ready, idShowtime, price);
            }
            default -> {
                return new StandardSeat(id, type, code, ready, idShowtime, price);
            }
        }
    }
    public Seat getSeat(String type, String code, boolean isEmpty, long idShowtime) {
        String typeUP = type.toUpperCase();
        switch (typeUP) {
            case "SWEETBOX" -> {
                return new SweetBox(type, code, isEmpty, idShowtime);
            }
            case "DELUXESEAT" -> {
                return new DeluxeSeat(type, code, isEmpty, idShowtime);
            }
            case "VIPSEAT" -> {
                return new VipSeat(type, code, isEmpty, idShowtime);
            }
            default -> {
                return new StandardSeat(type, code, isEmpty, idShowtime);
            }
        }
    }
    public Seat[][] getSeats(int rowSeat, int columnSeat, long idShowtime) {
        Seat[][] seats = new Seat[rowSeat][columnSeat];
        for (int i = 0; i < rowSeat; i++) {
            for (int k = 0; k < columnSeat; k++) {
                String seatCode = alphabet[i] + (k + 1);
                switch (i) {
                    case 0 -> seats[i][k] = getSeat("standard", seatCode, true, idShowtime);
                    case 1 -> seats[i][k] = getSeat("vipSeat", seatCode, true, idShowtime);
                    case 2 -> seats[i][k] = getSeat("deluxeSeat", seatCode, true, idShowtime);
                    default -> seats[i][k] = getSeat("sweetBox", seatCode, true, idShowtime);
                }
            }
        }
        return seats;
    }
}
