package model.utils;

import case_study_Enjoy_Galaxy.model.dao.iplm.MovieDAO;
import case_study_Enjoy_Galaxy.model.entity.Movie;

import java.text.ParseException;
import java.util.List;

public class Transporter {
    public static void main(String[] args) throws ParseException {
        moveMovie();
    }
    public static void moveMovie() throws ParseException {
        final String PATH = "src\\case_study_Enjoy_Galaxy\\model\\data\\movie.csv";
        List<Movie> movieList = FileReaderUtils.readMovieData(PATH);
        for (Movie movie : movieList) {
            MovieDAO.getMovieDAO().insertMovie(movie);
        }
    }
}
