package controller;

import model.entity.Movie;
import model.service.IMovieService;
import model.service.impl.MovieServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HomeController", urlPatterns = {"/", "/book"})
public class HomeController extends HttpServlet {
    private IMovieService movieService;

    public void init() {
        movieService = MovieServiceImpl.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/" -> {
                    request.setAttribute("movies", MovieServiceImpl.getInstance().getAll());
                    request.getRequestDispatcher("/WEB-INF/view/home/index.jsp").forward(request, response);
                }
                case "/book" -> {
                    long id = Long.parseLong(request.getParameter("idMovie"));
                    Movie movie = movieService.getMovieById(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}