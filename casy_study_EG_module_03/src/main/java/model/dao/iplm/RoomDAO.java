package model.dao.iplm;


import model.dao.IRoomDAO;
import model.entity.room.Room;
import model.factory.RoomFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements IRoomDAO {
    private static final String SELECT_ALL = "SELECT * FROM ROOM;";
    private static final String SELECT_BY_ID_MOVIE_THEATER = "SELECT * FROM ROOM WHERE ID_MOVIE_THEATER = ?;";

    private static final IRoomDAO roomDAO = new RoomDAO();
    private static final String SELECT_BY_ID = "SELECT * FROM ";

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
                long id = resultSet.getLong("id");;
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int numberRowSeat = resultSet.getInt("NUMBER_ROW_SEAT");
                int numberColumnSeat = resultSet.getInt("NUMBER_COLUMN_SEAT");
                long idMovieTheater = resultSet.getLong("ID_MOVIE_THEATER");
                Room room = RoomFactory.getInstance()
                        .getRoom(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
                rooms.add(room);
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
                long id = resultSet.getLong("id");;
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int numberRowSeat = resultSet.getInt("NUMBER_ROW_SEAT");
                int numberColumnSeat = resultSet.getInt("NUMBER_COLUMN_SEAT");
                Room room = RoomFactory.getInstance()
                        .getRoom(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

}
