package model.entity.seat.extend;

import model.entity.seat.Seat;

public class DeluxeSeat extends Seat {
    public DeluxeSeat(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime);
    }

    public DeluxeSeat(long id, String type, String code, boolean isEmpty, long idShowtime) {
        super(id, type, code, isEmpty, idShowtime);
    }

    @Override
    public double getSurcharge() {
        return 90000;
    }
}