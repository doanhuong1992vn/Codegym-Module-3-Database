package controller;

import model.entity.Movie;
import model.entity.Showtime;
import model.entity.cinema.Cinema;
import model.service.ICinemaService;
import model.service.IMovieService;
import model.service.impl.CinemaServiceImpl;
import model.service.impl.MovieServiceImpl;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HomeController", urlPatterns = {"/", "/movie"})
public class HomeController extends HttpServlet {
    private IMovieService movieService;
    private ICinemaService cinemaService;

    public void init() {
        movieService = MovieServiceImpl.getInstance();
        cinemaService = CinemaServiceImpl.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/" -> {
                    request.setAttribute("movies", MovieServiceImpl.getInstance().getAll());
                    request.getRequestDispatcher("/WEB-INF/view/home/index.jsp").forward(request, response);
                }
                case "/movie" -> {
                    long idMovie = Long.parseLong(request.getParameter("idMovie"));
                    Movie movie = movieService.getMovieById(idMovie);
                    Map<String, Set<Showtime>> mapShowtime = cinemaService.getMapShowtime(idMovie, new Date());
                    request.setAttribute("movie", movie);
                    request.setAttribute("mapShowtime", mapShowtime);
                    request.getRequestDispatcher("/WEB-INF/view/movie/movie-detail.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

    }
}