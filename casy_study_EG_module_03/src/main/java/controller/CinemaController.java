package controller;

import model.domain.Movie;
import model.domain.Showtime;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CinemaController", urlPatterns = {"/", "/showtime", "/seat", "/booking", "", "/ticket", "/home"})
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        HttpSession session = request.getSession();
        try {
            switch (action) {
                case "/", "", "/home" -> showMovies(request, response);
                case "/showtime" -> showShowtime(request, response, session);
                case "/seat" -> showSeats(request, response, session);
                case "/booking" -> bookTicket(request, response, session);
                case "/ticket" -> showTicket(request, response, session);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showTicket(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        User user = (User) session.getAttribute("user");
        List<DomainDTO> domainDTOList = cinemaService.getDomainDTOList(user.getId());
        session.setAttribute("domainDTOList", domainDTOList);
        request.getRequestDispatcher("/WEB-INF/view/ticket.jsp").forward(request, response);
    }

    private void bookTicket(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String[] idSeats = request.getParameterValues("idSeats");
        if (idSeats == null) {
            String message = "Vui lòng chọn ghế trước khi xác nhận";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/view/seat.jsp").forward(request, response);
        } else {
            session.setAttribute("idSeats", idSeats);
            User user = (User) session.getAttribute("user");
            DomainDTO domainDTO = (DomainDTO) session.getAttribute("domainDTO");
            Movie movie = (Movie) session.getAttribute("movie");
            domainDTO.setMovie(movie);
            List<DomainDTO> domainDTOList = ticketService.getDomainDTOList(idSeats, user.getId(), domainDTO);
            session.setAttribute("domainDTOList", domainDTOList);
            request.getRequestDispatcher("/WEB-INF/view/ticket.jsp").forward(request, response);
        }
    }

    private void showSeats(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        long idShowtime = Long.parseLong(request.getParameter("idShowtime"));
        Seat[][] seats = seatService.getSeatArrayByIdShowtime(idShowtime);
        session.setAttribute("seats", seats);
        DomainDTO domainDTO = cinemaService.getDomainDTO(idShowtime);
        session.setAttribute("domainDTO", domainDTO);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/view/seat.jsp").forward(request, response);
        }
    }

    private void showShowtime(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String dateParameter = request.getParameter("date");
        Date date = (dateParameter == null
                || dateParameter.equals("")
                || dateParameter.equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date())))
                ? new Date()
                : new SimpleDateFormat("yyyy-MM-dd").parse(dateParameter);
        long idMovie = Long.parseLong(request.getParameter("idMovie"));
        Movie movie = movieService.getMovieById(idMovie);
        Map<String, Set<Showtime>> mapShowtime = showtimeService.getMapShowtime(idMovie, date);
        String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);
        String message = mapShowtime.isEmpty()
                ? String.format("Không có suất chiếu trong ngày %s . Vui lòng chọn ngày khác", dateFormat)
                : String.format("Có %d suất chiếu trong ngày %s :",
                showtimeService.getNumberShowtime(mapShowtime), dateFormat);
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
}