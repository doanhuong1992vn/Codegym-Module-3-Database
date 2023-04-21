package controller;

import model.entity.Movie;
import model.entity.Showtime;
import model.entity.seat.Seat;
import model.service.ICinemaService;
import model.service.IMovieService;
import model.service.ISeatService;
import model.service.impl.CinemaServiceImpl;
import model.service.impl.MovieServiceImpl;
import model.service.impl.SeatServiceImpl;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HomeController", urlPatterns = {"/", "/movie", "/booking"})
public class HomeController extends HttpServlet {
    private IMovieService movieService;
    private ICinemaService cinemaService;
    private ISeatService seatService;

    public void init() {
        movieService = MovieServiceImpl.getMovieService();
        cinemaService = CinemaServiceImpl.getCinemaService();
        seatService = SeatServiceImpl.getSeatService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/" -> showMovies(request, response);
                case "/movie" -> showShowtime(request, response);
                case "/booking" -> {
                    long idShowtime = Long.parseLong(request.getParameter("idShowtime"));
                    Seat[][] seats = seatService.getSeatsByIdShowtime(idShowtime);
                    request.setAttribute("seats", seats);
                    request.getRequestDispatcher("/WEB-INF/view/booking/booking.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showShowtime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idMovie = Long.parseLong(request.getParameter("idMovie"));
        Movie movie = movieService.getMovieById(idMovie);
        Map<String, Set<Showtime>> mapShowtime = cinemaService.getMapShowtime(idMovie, new Date());
        request.setAttribute("movie", movie);
        request.setAttribute("mapShowtime", mapShowtime);
        request.getRequestDispatcher("/WEB-INF/view/movie/movie-detail.jsp").forward(request, response);
    }

    private static void showMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies", MovieServiceImpl.getMovieService().getAll());
        request.getRequestDispatcher("/WEB-INF/view/home/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

    }
}