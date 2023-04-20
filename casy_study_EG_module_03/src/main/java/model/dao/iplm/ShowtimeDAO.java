package model.dao.iplm;

import model.dao.IShowtimeDAO;
import model.entity.Showtime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowtimeDAO implements IShowtimeDAO {
    private static final String SELECT_ALL = "SELECT * FROM SHOWTIME;";
    private static final String SELECT_BY_ID_ROOM = "SELECT * FROM SHOWTIME WHERE ID_ROOM = ?";
    private static final String INSERT_SHOWTIME = "INSERT INTO SHOWTIME(START_TIME, END_TIME, ID_ROOM, ID_MOVIE) VALUES (?,?,?,?);";
    private static final IShowtimeDAO showtimeDAO = new ShowtimeDAO();

    private ShowtimeDAO() {
    }

    public static IShowtimeDAO getShowtimeDAO() {
        return showtimeDAO;
    }
    @Override
    public void insertShowtime(Showtime showtime) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOWTIME)) {
            preparedStatement.setLong(1, showtime.getId());
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(showtime.getStartTime().getTime()));
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(showtime.getEndTime().getTime()));
            preparedStatement.setLong(3, showtime.getIdRoom());
            preparedStatement.setLong(4, showtime.getIdMovie());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Showtime> getAll() {
        return null;
    }

    @Override
    public List<Showtime> getShowtimeListByIdRoom(long idRoom) {
        List<Showtime> showtimeList = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_ROOM)) {
            preparedStatement.setLong(1, idRoom);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                Date startTime = resultSet.getTimestamp("START_TIME");
                Date endTime = resultSet.getTimestamp("END_TIME");
                long idMovie = resultSet.getLong("ID_MOVIE");
                showtimeList.add(new Showtime(id, startTime, endTime, idRoom, idMovie));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimeList;
    }
}
