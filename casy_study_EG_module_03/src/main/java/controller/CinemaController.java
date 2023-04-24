package controller;

import model.domain.Movie;
import model.domain.Showtime;
import model.domain.Ticket;
import model.domain.seat.Seat;
import model.domain.users.User;
import model.dto.DomainDTO;
import model.service.*;
import model.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CinemaController", urlPatterns = {"/", "/showtime", "/seat", "/booking"})
public class CinemaController extends HttpServlet {
    private IMovieService movieService;
    private IShowtimeService showtimeService;
    private ISeatService seatService;
    private ITicketService ticketService;
    private ICinemaService cinemaService;

    public void init() {
        movieService = MovieServiceImpl.getMovieService();
        showtimeService = ShowtimeServiceImpl.getShowtimeService();
        seatService = SeatServiceImpl.getSeatService();
        ticketService = TicketServiceImpl.getTicketService();
        cinemaService = CinemaServiceImpl.getCinemaService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        HttpSession session = request.getSession();
        try {
            switch (action) {
                case "/" -> showMovies(request, response);
                case "/showtime" -> showShowtime(request, response, session);
                case "/seat" -> showSeats(request, response, session);
                case "/booking" -> {
                    String[] idSeats = request.getParameterValues("idSeats");
                    if (idSeats == null) {
                        String message = "Vui lòng chọn ghế trước khi xác nhận";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("/WEB-INF/view/seat.jsp").forward(request, response);
                    }
                    User user = (User) session.getAttribute("user");
                    if (user == null) {
                        session.setAttribute("idSeats", idSeats);
                        request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
                    } else {
                        Map<Seat, Ticket> seatAndTicketMap = ticketService.getSeatAndTicketMap(idSeats, user.getId());
                        request.setAttribute("seatAndTicketMap", seatAndTicketMap);
                        request.getRequestDispatcher("/WEB-INF/view/ticket.jsp").forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSeats(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        long idShowtime = Long.parseLong(request.getParameter("idShowtime"));
        Seat[][] seats = seatService.getSeatsByIdShowtime(idShowtime);
        session.setAttribute("seats", seats);
        DomainDTO domainDTO = cinemaService.getDomainDTO(idShowtime);
        session.setAttribute("domainDTO", domainDTO);
        request.getRequestDispatcher("/WEB-INF/view/seat.jsp").forward(request, response);
    }

    private void showShowtime(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String dateParameter = request.getParameter("date");
        Date date = (dateParameter == null || dateParameter.equals(""))
                ? new Date()
                : new SimpleDateFormat("yyyy-MM-dd").parse(dateParameter);
        long idMovie = Long.parseLong(request.getParameter("idMovie"));
        Movie movie = movieService.getMovieById(idMovie);
        Map<String, Set<Showtime>> mapShowtime = showtimeService.getMapShowtime(idMovie, date);
        String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);
        String message = mapShowtime.isEmpty()
                ? String.format("Không có suất chiếu trong ngày %s . Vui lòng chọn ngày khác", dateFormat)
                : String.format("Có %d suất chiếu trong ngày %s :", mapShowtime.size(), dateFormat);
        session.setAttribute("movie", movie);
        request.setAttribute("message", message);
        request.setAttribute("mapShowtime", mapShowtime);
        request.getRequestDispatcher("/WEB-INF/view/showtime.jsp").forward(request, response);
    }

    private void showMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getParameter("search") != null) {
            String search = request.getParameter("search");
            List<Movie> movies = movieService.getMoviesBySearch(search);
            if (movies.isEmpty()) {
                String message = "Không tìm thấy phim nào khớp với từ khóa \"" + search + "\"";
                request.setAttribute("message", message);
            }
            request.setAttribute("movies", movies);
        } else {
            request.setAttribute("movies", movieService.getAll());
        }
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

    }
}