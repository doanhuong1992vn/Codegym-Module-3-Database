package com.example.practice_simple_dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TranslationServlet", value = "/translate")
public class TranslationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch");
        String result = dictionary.get(search);
        if (result == null) {
            result = "Không tìm thấy ";
        }
        request.setAttribute("result", result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request, response);

//        if (result != null) {
//            writer.println("Word: " + search);
//            writer.println("<br>");
//            writer.println("Result: " + result);
//        } else {
//            writer.println("Not found");
//        }
//
//        writer.println("</html>");
    }

    public void destroy() {
    }
}