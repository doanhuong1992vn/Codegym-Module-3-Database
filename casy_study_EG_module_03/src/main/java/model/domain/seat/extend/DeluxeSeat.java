package model.domain.seat.extend;

import model.domain.seat.Seat;

public class DeluxeSeat extends Seat {
    public DeluxeSeat(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime, 1);
    }

    public DeluxeSeat(long id, String type, String code, boolean isEmpty, long idShowtime, double price) {
        super(id, type, code, isEmpty, idShowtime, 1, price);
    }

    @Override
    public double getSurcharge() {
        return 90000;
    }
}
