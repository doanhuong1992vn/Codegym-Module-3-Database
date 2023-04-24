package model.domain.seat.extend;

import model.domain.seat.Seat;

public class StandardSeat extends Seat {
    public StandardSeat(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime, 1);
    }

    public StandardSeat(long id, String type, String code, boolean isEmpty, long idShowtime, double price) {
        super(id, type, code, isEmpty, idShowtime, 1, price);
    }

    @Override
    public double getSurcharge() {
        return 50000;
    }
}
