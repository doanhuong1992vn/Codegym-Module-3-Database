package model.dao.iplm;


import model.dao.ISeatDAO;
import model.domain.room.Room;
import model.domain.seat.Seat;
import model.factory.SeatFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO implements ISeatDAO {
    private static final String SELECT_SEAT_BY_ID = "SELECT * FROM SEAT WHERE ID = ?";
    private static final String SELECT_SEATS_BY_ID_SHOWTIME = "SELECT * FROM SEAT WHERE ID_SHOWTIME = ?;";
    private static final String INSERT_SEAT = "INSERT INTO SEAT(TYPE, CODE, IS_EMPTY, ID_SHOWTIME, PRICE) VALUES (?,?,?,?,?);";
    private static final ISeatDAO seatDAO = new SeatDAO();

    private SeatDAO() {
    }

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
                seats.add(getSeat(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seats;
    }

    private static Seat getSeat(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("ID");
        String type = resultSet.getString("TYPE");
        String code = resultSet.getString("CODE");
        boolean ready = resultSet.getBoolean("IS_EMPTY");
        double price = resultSet.getDouble("PRICE");
        long idShowtime = resultSet.getLong("ID_SHOWTIME");
        return SeatFactory.getInstance().getSeat(id, type, code, ready, idShowtime, price);
    }

    @Override
    public void insertSeat(Seat seat) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SEAT)) {
            preparedStatement.setString(1, seat.getType());
            preparedStatement.setString(2, seat.getCode());
            preparedStatement.setBoolean(3, seat.isEmpty());
            preparedStatement.setLong(4, seat.getIdShowtime());
            preparedStatement.setDouble(5, seat.getPrice());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Seat getSeatById(long idSeat) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SEAT_BY_ID)) {
            preparedStatement.setLong(1, idSeat);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getSeat(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Hàm main này dùng trong trường hợp set lại toàn bộ cột PRICE của table SEAT trong database
//    public static void main(String[] args) {
//        try (Connection connection = ConnectionDAO.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SEAT")) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                long id = resultSet.getLong("ID");
//                String type = resultSet.getString("TYPE");
//                String code = resultSet.getString("CODE");
//                boolean isEmpty = resultSet.getBoolean("IS_EMPTY");
//                long idShowtime = resultSet.getLong("ID_SHOWTIME");
//                Seat seat = SeatFactory.getInstance().getSeat(id, type, code, isEmpty, idShowtime, 0);
//                Room room = RoomDAO.getRoomDAO().getRoomByIdShowtime(idShowtime);
//                seat.setPrice(seat.getSurcharge() + room.getSurcharge());
//                String SQL = "INSERT INTO SEAT (ID, TYPE, CODE, IS_EMPTY, ID_SHOWTIME, PRICE) VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE PRICE = ?;";
//                try (Connection connection2 = ConnectionDAO.getInstance().getConnection();
//                     PreparedStatement preparedStatement2 = connection2.prepareStatement(SQL)) {
//                    preparedStatement2.setLong(1, seat.getId());
//                    preparedStatement2.setString(2, seat.getType());
//                    preparedStatement2.setString(3, seat.getCode());
//                    preparedStatement2.setBoolean(4, seat.isEmpty());
//                    preparedStatement2.setLong(5, seat.getIdShowtime());
//                    preparedStatement2.setDouble(6, seat.getPrice());
//                    preparedStatement2.setDouble(7, seat.getPrice());
//                    preparedStatement2.executeUpdate();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
