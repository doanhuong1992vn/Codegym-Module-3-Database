package model.dao.iplm;

import model.builder.showtime_builder.ShowtimeConcreteBuilder;
import model.dao.IShowtimeDAO;
import model.entity.Showtime;
import model.entity.cinema.Cinema;
import model.factory.CinemaFactory;
import model.utils.Converter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ShowtimeDAO implements IShowtimeDAO {
//    private static final String SELECT_ALL = "SELECT * FROM SHOWTIME;";
    private static final String SELECT_BY_ID_MOVIE = "SELECT * FROM SHOWTIME WHERE ID_MOVIE = ?";
    private static final String SELECT_BY_ID_ROOM = "SELECT * FROM SHOWTIME WHERE ID_ROOM = ?";
    private static final String INSERT_SHOWTIME = "INSERT INTO SHOWTIME(START_TIME, END_TIME, ID_ROOM, ID_MOVIE) VALUES (?,?,?,?);";
    private static final String SELECT_MAP = "CALL GET_MAP_SHOWTIME(?)";
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
    public List<Showtime> getShowtimeList(long id, String type) {
        String select = null;
        if (type.equalsIgnoreCase("idRoom")) {
            select = SELECT_BY_ID_ROOM;
        } else if (type.equalsIgnoreCase("idMovie")) {
            select = SELECT_BY_ID_MOVIE;
        }
        List<Showtime> showtimeList = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idShowtime = resultSet.getLong("ID");
                Date startTime = resultSet.getTimestamp("START_TIME");
                Date endTime = resultSet.getTimestamp("END_TIME");
                long idRoom = resultSet.getLong("ID_ROOM");
                long idMovie = resultSet.getLong("ID_MOVIE");
                showtimeList.add(new Showtime(idShowtime, startTime, endTime, idRoom, idMovie));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimeList;
    }

    @Override
    public Map<String, Set<Showtime>> getMap(long idMovie, Date date) {
        Map<String, Set<Showtime>> map = new HashMap<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAP)) {
            preparedStatement.setLong(1, idMovie);
            ResultSet resultSet = preparedStatement.executeQuery();
            Date nextDay = Converter.convertToBeginningOfNextDay(date);
            while (resultSet.next()) {
                Date startTime = resultSet.getTimestamp("START_TIME");
                if (startTime.after(date) && startTime.before(nextDay)) {
                    String name = resultSet.getString("NAME");

                    long idShowtime = resultSet.getLong("ID_SHOWTIME");
                    Date endTime = resultSet.getTimestamp("END_TIME");
                    long idRoom = resultSet.getLong("ID_ROOM");
                    Showtime showtime = new Showtime(idShowtime, startTime, endTime, idRoom, idMovie);
                    if (map.isEmpty() || !map.containsKey(name)) {
                        map.put(name, new TreeSet<>(Comparator.comparingLong(Showtime::getTimeOfStartTime)));
                    }
                    map.get(name).add(showtime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
