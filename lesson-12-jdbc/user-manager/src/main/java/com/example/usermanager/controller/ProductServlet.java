package com.example.usermanager.controller;

import com.example.usermanager.dao.IProductDAO;
import com.example.usermanager.dao.ProductDAO;
import com.example.usermanager.model.CartLine;
import com.example.usermanager.model.CartLineService;
import com.example.usermanager.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products", "", "/"})
public class ProductServlet extends HttpServlet {
    private IProductDAO productDAO;
    private CartLineService cartLineService;
    public void init() {
        productDAO = new ProductDAO();
        cartLineService = new CartLineService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (Objects.equals(request.getServletPath(), "/update")) {
            action = "update";
        }
        try {
            switch (action) {
                case "buy" -> buyProduct(request, response);
                case "remove" -> removeCartLine(request, response);
                case "update" -> updateCartLine(request, response);
                default -> products(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateCartLine(HttpServletRequest request, HttpServletResponse response) {
        String[] quantities = request.getParameterValues("quantity");
        List<CartLine> cartLines = (List<CartLine>) request.getSession().getAttribute("cartLines");
        cartLineService.setCartLines(quantities, cartLines);
    }

    private void removeCartLine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("id"));
        productDAO.removeCartLine(idProduct);
        List<CartLine> cartLines = productDAO.getCartLines();
        float totalPrice = cartLineService.getTotalPrice(cartLines);
        request.getSession().setAttribute("cartLines", cartLines);
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    private void buyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("id"));
        productDAO.insertCartLine(idProduct);
        List<CartLine> cartLines = productDAO.getCartLines();
        float totalPrice = cartLineService.getTotalPrice(cartLines);
        request.getSession().setAttribute("cartLines", cartLines);
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    private void products(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productDAO.getAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
