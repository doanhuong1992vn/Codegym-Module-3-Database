package model.dao.iplm;


import model.builder.movie_builder.IMovieBuilder;
import model.builder.movie_builder.MovieConcreteBuilder;
import model.dao.IMovieDAO;
import model.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDAO implements IMovieDAO {
    private static final String SELECT_ALL = "SELECT * FROM MOVIE;";
    private static final String INSERT_MOVIE = "INSERT INTO MOVIE(NAME, DIRECTOR, ACTORS, GENRE, PREMIERE_DATE, DURATION, LANGUAGE, CONTENT, URL_IMAGE) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final IMovieDAO movieDAO = new MovieDAO();
    private static final String SELECT_BY_ID = "SELECT * FROM MOVIE WHERE ID = ?";

    private MovieDAO() {
    }

    public static IMovieDAO getMovieDAO() {
        return movieDAO;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies.add(getMovie(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    private Movie getMovie(ResultSet resultSet) throws SQLException, ParseException {
        long id = resultSet.getLong("ID");
        String name = resultSet.getString("NAME");
        String director = resultSet.getString("DIRECTOR");
        String actors = resultSet.getString("ACTORS");
        String genre = resultSet.getString("GENRE");
        Date premiereDate = new Date(resultSet.getDate("PREMIERE_DATE").getTime());
        int duration = resultSet.getInt("DURATION");
        String language = resultSet.getString("LANGUAGE");
        String content = resultSet.getString("CONTENT");
        String urlImage = resultSet.getString("URL_IMAGE");
        IMovieBuilder movieBuilder = new MovieConcreteBuilder()
                .duration(duration)
                .genre(genre)
                .actors(actors)
                .content(content)
                .director(director)
                .language(language)
                .premiereDate(premiereDate)
                .id(id)
                .name(name)
                .urlImage(urlImage);
        return movieBuilder.buildFull();
    }

    @Override
    public void insertMovie(Movie movie) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE)) {
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getDirector());
            preparedStatement.setString(3, movie.getActors());
            preparedStatement.setString(4, movie.getGenre());
            preparedStatement.setDate(5, new java.sql.Date(movie.getPremiereDate().getTime()));
            preparedStatement.setInt(6, movie.getDuration());
            preparedStatement.setString(7, movie.getLanguage());
            preparedStatement.setString(8, movie.getContent());
            preparedStatement.setString(9, movie.getUrlImage());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie getMovieById(long id) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getMovie(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
