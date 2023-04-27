package controller;

import model.domain.users.User;
import model.service.IMovieService;
import model.service.IUserService;
import model.service.impl.MovieServiceImpl;
import model.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserController", urlPatterns = {"/logged", "/register", "/logout", "/login"})
public class UserController extends HttpServlet {
    private IUserService userService;
    private IMovieService movieService;

    @Override
    public void init() {
        userService = UserServiceImpl.getUserService();
        movieService = MovieServiceImpl.getMovieService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        HttpSession session = request.getSession();
        try {
            switch (action) {
                case "/login" -> request
                        .getRequestDispatcher("/WEB-INF/view/user/login.jsp")
                        .forward(request, response);
                case "/logout" -> {
                    session.invalidate();
                    showHomePage(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        HttpSession session = request.getSession();
        try {
            switch (action) {
                case "/logged" -> loginUser(request, response, session);
                case "/register" -> register(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        User user = userService.login(loginName, password);
        if (user == null) {
            String message = "Thông tin đăng nhập không chính xác";
            showLoginForm(request, response, message);
            return;
        } else {
            session.setAttribute("user", user);
        }
        if (session.getAttribute("seats") == null) {
            showHomePage(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/view/seat.jsp").forward(request, response);
        }
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies", movieService.getAll());
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean registerSuccessful = userService.register(name, phoneNumber, email, password);
        String message = registerSuccessful
                ? String.format("Đăng ký thành công với SĐT %s và email %s! Xin mời đăng nhập", phoneNumber, email)
                : String.format("Đăng ký không thành công. SĐT %s hoặc email %s đã được sử dụng.", phoneNumber, email);
        showLoginForm(request, response, message);
    }
}
