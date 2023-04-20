package model.entity.seat.extend;


import model.entity.seat.Seat;

public class SweetBox extends Seat {
    public SweetBox(String type, String code, boolean isEmpty, long idShowtime) {
        super(type, code, isEmpty, idShowtime, 2);
    }

    public SweetBox(long id, String type, String code, boolean isEmpty, long idShowtime) {
        super(id, type, code, isEmpty, idShowtime, 2);
    }

    @Override
    public double getSurcharge() {
        return 200000;
    }
}
