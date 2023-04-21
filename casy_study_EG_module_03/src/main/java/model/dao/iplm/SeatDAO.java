package model.dao.iplm;



import model.dao.ISeatDAO;
import model.entity.seat.Seat;
import model.factory.SeatFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO implements ISeatDAO {
    private static final String SELECT_SEATS_BY_ID_SHOWTIME = "SELECT * FROM SEAT WHERE ID_SHOWTIME = ?;";
    private static final String INSERT_SEAT = "INSERT INTO SEAT(TYPE, CODE, READY, ID_SHOWTIME) VALUES (?,?,?,?);";
    private static final ISeatDAO seatDAO = new SeatDAO();
    private SeatDAO(){}
    public static ISeatDAO getSeatDAO() {
        return seatDAO;
    }
    @Override
    public List<Seat> getSeatsByIdShowtime(long idShowtime) {
        List<Seat> seats = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SEATS_BY_ID_SHOWTIME)) {
            preparedStatement.setLong(1, idShowtime);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String type = resultSet.getString("TYPE");
                String code = resultSet.getString("CODE");
                boolean ready = resultSet.getBoolean("IS_EMPTY");
                Seat seat = SeatFactory.getInstance().getSeat(id, type, code, ready, idShowtime);
                seats.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seats;
    }

    @Override
    public void insertSeat(Seat seat) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SEAT)) {
            preparedStatement.setString(1, seat.getType());
            preparedStatement.setString(2, seat.getCode());
            preparedStatement.setBoolean(3, seat.isEmpty());
            preparedStatement.setLong(4, seat.getIdShowtime());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
