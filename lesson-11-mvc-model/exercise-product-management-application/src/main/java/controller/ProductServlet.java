package controller;

import model.entity.Product;
import model.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products", ""})
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "search" -> viewProductList(request, response);
            case "create" -> showCreateForm(request, response);
            case "edit" -> showEditForm(request, response);
            case "delete" -> showDeleteForm(request, response);
            case "view" -> viewProduct(request, response);
            default -> allProducts(request, response);
        }
    }

/*    private void viewProductList(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search");
        List<Product> products = ProductServiceImpl.getProductService().getProductsByKeyword(keyword);
        request.setAttribute("productsSearch", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void allProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = ProductServiceImpl.getProductService().getAll();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}