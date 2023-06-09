package model.domain.seat.extend;

import model.domain.seat.Seat;

public class VipSeat extends Seat {
    @Override
    public double getSurcharge() {
        return 70000;
    }

    public VipSeat(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime, 1);
    }

    public VipSeat(long id, String type, String code, boolean isEmpty, long idShowtime, double price) {
        super(id, type, code, isEmpty, idShowtime, 1, price);
    }
}
