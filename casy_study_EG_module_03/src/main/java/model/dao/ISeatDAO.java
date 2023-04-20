package model.dao;


import model.entity.seat.Seat;

import java.util.List;

public interface ISeatDAO {
    List<Seat> getSeatsByIdShowtime(long idShowtime);
    void insertSeat(Seat seat);
}
