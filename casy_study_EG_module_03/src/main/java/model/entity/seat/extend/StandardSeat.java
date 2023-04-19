package model.entity.seat.extend;

import model.entity.seat.Seat;

public class StandardSeat extends Seat {
    public StandardSeat(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime);
    }

    public StandardSeat(long id, String type, String code, boolean isEmpty, long idShowtime) {
        super(id, type, code, isEmpty, idShowtime);
    }

    @Override
    public double getSurcharge() {
        return 70000;
    }
}
