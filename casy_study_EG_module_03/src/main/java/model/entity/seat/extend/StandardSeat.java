package model.entity.seat.extend;

import model.entity.seat.Seat;

public class StandardSeat extends Seat {
    public StandardSeat(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime, 1);
    }

    public StandardSeat(long id, String type, String code, boolean isEmpty, long idShowtime) {
        super(id, type, code, isEmpty, idShowtime, 1);
    }

    @Override
    public double getSurcharge() {
        return 70000;
    }
}
