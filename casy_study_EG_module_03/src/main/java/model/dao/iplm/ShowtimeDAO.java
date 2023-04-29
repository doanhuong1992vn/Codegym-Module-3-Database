package model.dao.iplm;

import model.dao.IShowtimeDAO;
import model.domain.Showtime;
import model.utils.Converter;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class ShowtimeDAO implements IShowtimeDAO {
    private static final String SELECT_BY_ID_MOVIE = "SELECT * FROM SHOWTIME WHERE ID_MOVIE = ?";
    private static final String SELECT_BY_ID_ROOM = "SELECT SHOWTIME.ID AS ID_SHOWTIME, " +
            "SHOWTIME.START_TIME AS START_SHOWTIME, " +
            "SHOWTIME.END_TIME AS END_SHOWTIME, " +
            "SHOWTIME.ID_ROOM AS ID_ROOM," +
            "SHOWTIME.ID_MOVIE AS ID_MOVIE " +
            "FROM SHOWTIME WHERE ID_ROOM = ?";
    private static final String INSERT_SHOWTIME = "INSERT INTO SHOWTIME(START_TIME, END_TIME, ID_ROOM, ID_MOVIE) VALUES (?,?,?,?);";
    private static final String SELECT_MAP = "CALL GET_MAP_SHOWTIME(?)";

    public static IShowtimeDAO getShowtimeDAO() {
        return new ShowtimeDAO();
    }
    @Override
    public long insertShowtime(Showtime showtime) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOWTIME, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(showtime.getStartTime().getTime()));
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(showtime.getEndTime().getTime()));
            preparedStatement.setLong(3, showtime.getIdRoom());
            preparedStatement.setLong(4, showtime.getIdMovie());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
                showtimeList.add(getShowtime(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimeList;
    }
    @Override
    public Showtime getShowtime(ResultSet resultSet) throws SQLException {
        long idShowtime = resultSet.getLong("ID_SHOWTIME");
        Date startTime = resultSet.getTimestamp("START_SHOWTIME");
        Date endTime = resultSet.getTimestamp("END_SHOWTIME");
        long idRoom = resultSet.getLong("ID_ROOM");
        long idMovie = resultSet.getLong("ID_MOVIE");
        return new Showtime(idShowtime, startTime, endTime, idRoom, idMovie);
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
