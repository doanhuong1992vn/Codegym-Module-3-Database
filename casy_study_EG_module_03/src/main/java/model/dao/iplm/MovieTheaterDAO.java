package model.dao.iplm;

import case_study_Enjoy_Galaxy.model.dao.IMovieTheaterDAO;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.factory.MovieTheaterFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieTheaterDAO implements IMovieTheaterDAO {
    private static final MovieTheaterDAO movieTheaterDAO = new MovieTheaterDAO();
    private static final String INSERT_MOVIE_THEATER = "INSERT INTO MOVIE_THEATER (TYPE, NAME, ADDRESS) VALUES (?,?,?);";
    private static final String SELECT_ALL = "SELECT * FROM MOVIE_THEATER;";
    private MovieTheaterDAO () {}
    public static MovieTheaterDAO getInstance() {
        return movieTheaterDAO;
    }
    @Override
    public void insertMovieTheater(MovieTheater movieTheater) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE_THEATER)) {
            preparedStatement.setString(1, movieTheater.getType());
            preparedStatement.setString(2, movieTheater.getName());
            preparedStatement.setString(3, movieTheater.getAddress());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MovieTheater> getAll() {
        List<MovieTheater> movieTheaterList = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                MovieTheater movieTheater = MovieTheaterFactory.getInstance().getMovieTheater(id, type, name, address);
                movieTheaterList.add(movieTheater);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieTheaterList;
    }
}
