package model.factory;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.entity.seat.DeluxeSeat;
import case_study_Enjoy_Galaxy.model.entity.seat.StandardSeat;
import case_study_Enjoy_Galaxy.model.entity.seat.SweetBox;
import case_study_Enjoy_Galaxy.model.entity.seat.VipSeat;

public class SeatFactory {
    private static final String[] alphabet =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
    private static final SeatFactory seatFactory = new SeatFactory();
    private SeatFactory(){
    }
    public static SeatFactory getInstance() {
        return seatFactory;
    }
    public Seat getSeat(String typeSeat, String seatCode) {
        String typeSeatToUpperCase = typeSeat.toUpperCase();
        switch (typeSeatToUpperCase) {
            case "SWEETBOX" -> {
                return new SweetBox(seatCode);
            }
            case "DELUXESEAT" -> {
                return new DeluxeSeat(seatCode);
            }
            case "VIPSEAT" -> {
                return new VipSeat(seatCode);
            }
            default -> {
                return new StandardSeat(seatCode);
            }
        }
    }
    public Seat getSeat(long id, String type, String code, boolean ready, long idShowtime) {
        String typeUP = type.toUpperCase();
        switch (typeUP) {
            case "SWEETBOX" -> {
                return new SweetBox(id, type, code, ready, idShowtime);
            }
            case "DELUXESEAT" -> {
                return new DeluxeSeat(id, type, code, ready, idShowtime);
            }
            case "VIPSEAT" -> {
                return new VipSeat(id, type, code, ready, idShowtime);
            }
            default -> {
                return new StandardSeat(id, type, code, ready, idShowtime);
            }
        }
    }
    public Seat getSeat(String type, String code, boolean ready, long idShowtime) {
        String typeUP = type.toUpperCase();
        switch (typeUP) {
            case "SWEETBOX" -> {
                return new SweetBox(type, idShowtime, code, ready);
            }
            case "DELUXESEAT" -> {
                return new DeluxeSeat(type, idShowtime, code, ready);
            }
            case "VIPSEAT" -> {
                return new VipSeat(type, idShowtime, code, ready);
            }
            default -> {
                return new StandardSeat(type, idShowtime, code, ready);
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
