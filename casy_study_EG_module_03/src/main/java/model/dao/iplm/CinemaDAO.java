package model.dao.iplm;



import model.dao.ICinemaDAO;
import model.entity.cinema.Cinema;
import model.factory.CinemaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO implements ICinemaDAO {
    private static final String INSERT_MOVIE_THEATER = "INSERT INTO MOVIE_THEATER (TYPE, NAME, ADDRESS) VALUES (?,?,?);";
    private static final String SELECT_ALL = "SELECT * FROM MOVIE_THEATER;";
    public static ICinemaDAO getInstance() {
        return new CinemaDAO();
    }
    @Override
    public void insertMovieTheater(Cinema cinema) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE_THEATER)) {
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
                long id = resultSet.getLong("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Cinema cinema = CinemaFactory.getInstance().getCinema(id, type, name, address);
                cinemaList.add(cinema);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cinemaList;
    }
}
