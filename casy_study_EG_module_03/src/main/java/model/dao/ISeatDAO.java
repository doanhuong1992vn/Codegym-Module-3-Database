package model.dao;


import model.domain.seat.Seat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ISeatDAO {
    List<Seat> getSeatsByIdShowtime(long idShowtime);
    void insertSeat(Seat seat);
    Seat getSeatById(long idSeat);

    void updateSeat(long idSeat);
    Seat getSeat(ResultSet resultSet) throws SQLException;
}
