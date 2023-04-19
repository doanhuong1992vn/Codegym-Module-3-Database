package model.dao;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.List;

public interface ISeatDAO {
    List<Seat> getSeatsByIdShowtime(long idShowtime);
    void insertSeat(Seat seat);
}
