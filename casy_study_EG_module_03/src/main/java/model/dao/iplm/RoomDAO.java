package model.dao.iplm;


import model.dao.IRoomDAO;
import model.entity.room.Room;
import model.factory.RoomFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements IRoomDAO {
    private static final String SELECT_ALL = "SELECT * FROM ROOM;";
    private static final String SELECT_BY_ID_MOVIE_THEATER = "SELECT * FROM ROOM WHERE ID_MOVIE_THEATER = ?;";

    private static final IRoomDAO roomDAO = new RoomDAO();
    private static final String SELECT_BY_ID_SHOWTIME = "SELECT ROOM.ID AS ID, ROOM.TYPE AS TYPE, ROOM.NAME AS NAME, ROOM.NUMBER_ROW_SEAT AS NUMBER_ROW_SEAT, ROOM.NUMBER_COLUMN_SEAT AS NUMBER_COLUMN_SEAT, ROOM.ID_CINEMA AS ID_CINEMA FROM ROOM JOIN SHOWTIME ON ROOM.ID = SHOWTIME.ID_ROOM WHERE SHOWTIME.ID = ?";

    private RoomDAO() {}
    public static IRoomDAO getRoomDAO() {
        return roomDAO;
    }

    @Override
    public List<Room> getAll() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rooms.add(getRoomByResultSet(resultSet));
            }
        } catch (Exception e) {
                 e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public List<Room> getRoomListByIdMovieTheater(long idMovieTheater) {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_MOVIE_THEATER)) {
            preparedStatement.setLong(1, idMovieTheater);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rooms.add(getRoomByResultSet(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
    public Room getRoomByIdShowtime(long idShowtime) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SHOWTIME)) {
            preparedStatement.setLong(1, idShowtime);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return getRoomByResultSet(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Room getRoomByResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String type = resultSet.getString("type");
        String name = resultSet.getString("name");
        int numberRowSeat = resultSet.getInt("NUMBER_ROW_SEAT");
        int numberColumnSeat = resultSet.getInt("NUMBER_COLUMN_SEAT");
        long idCinema = resultSet.getLong("ID_CINEMA");
        return RoomFactory.getInstance()
                .getRoom(id, type, name, numberRowSeat, numberColumnSeat, idCinema);
    }

}
