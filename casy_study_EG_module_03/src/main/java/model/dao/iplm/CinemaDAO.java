package model.dao.iplm;



import model.dao.ICinemaDAO;
import model.domain.Showtime;
import model.domain.cinema.Cinema;
import model.domain.room.Room;
import model.dto.DomainDTO;
import model.factory.CinemaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO implements ICinemaDAO {
    private static final String INSERT_CINEMA = "INSERT INTO CINEMA (TYPE, NAME, ADDRESS) VALUES (?,?,?);";
    private static final String SELECT_ALL = "SELECT ID AS ID_CINEMA, TYPE AS TYPE_CINEMA, NAME AS NAME_CINEMA, ADDRESS AS ADDRESS_CINEMA FROM CINEMA;";
    private static final String SELECT_DOMAIN_DTO = "SELECT CINEMA.ID AS ID_CINEMA," +
            "CINEMA.TYPE AS TYPE_CINEMA, " +
            "    CINEMA.NAME AS NAME_CINEMA, " +
            "    CINEMA.ADDRESS AS ADDRESS_CINEMA, " +
            "    ROOM.ID AS ID_ROOM, " +
            "    ROOM.TYPE AS TYPE_ROOM, " +
            "    ROOM.NAME AS NAME_ROOM, " +
            "    ROOM.NUMBER_ROW_SEAT AS NUMBER_ROW_SEAT, " +
            "    ROOM.NUMBER_COLUMN_SEAT AS NUMBER_COLUMN_SEAT, " +
            "    SHOWTIME.ID AS ID_SHOWTIME, " +
            "    SHOWTIME.START_TIME AS START_SHOWTIME, " +
            "    SHOWTIME.END_TIME AS END_SHOWTIME, " +
            "    SHOWTIME.ID_MOVIE AS ID_MOVIE " +
            "FROM SHOWTIME " +
            "JOIN ROOM ON SHOWTIME.ID_ROOM = ROOM.ID " +
            "JOIN CINEMA ON ROOM.ID_CINEMA = CINEMA.ID " +
            "WHERE SHOWTIME.ID = ?;";
    public static ICinemaDAO getInstance() {
        return new CinemaDAO();
    }
    @Override
    public void insertMovieTheater(Cinema cinema) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CINEMA)) {
            preparedStatement.setString(1, cinema.getType());
            preparedStatement.setString(2, cinema.getName());
            preparedStatement.setString(3, cinema.getAddress());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cinema> getAll() {
        List<Cinema> cinemaList = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cinemaList.add(getCinema(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cinemaList;
    }

    public Cinema getCinema(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("ID_CINEMA");
        String type = resultSet.getString("TYPE_CINEMA");
        String name = resultSet.getString("NAME_CINEMA");
        String address = resultSet.getString("ADDRESS_CINEMA");
        return CinemaFactory.getInstance().getCinema(id, type, name, address);
    }

    @Override
    public DomainDTO getDomainDTO(long idShowtime) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOMAIN_DTO)) {
            preparedStatement.setLong(1, idShowtime);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Cinema cinema = getCinema(resultSet);
                Room room = RoomDAO.getRoomDAO().getRoom(resultSet);
                Showtime showtime = ShowtimeDAO.getShowtimeDAO().getShowtime(resultSet);
                return new DomainDTO(cinema, room, showtime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
