package model.entity.seat.extend;

import model.entity.seat.Seat;

public class VipSeat extends Seat {
    @Override
    public double getSurcharge() {
        return 40000;
    }

    public VipSeat(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime, 1);
    }

    public VipSeat(long id, String type, String code, boolean isEmpty, long idShowtime) {
        super(id, type, code, isEmpty, idShowtime, 1);
    }
}
