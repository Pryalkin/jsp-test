package com.example.jsptest;

import java.io.*;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "getUsers", value = "/get-users")
public class UsersServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        Double rating = Double.valueOf(request.getParameter("rating"));
        Integer numberOfVisits = Integer.valueOf(request.getParameter("numberOfVisits"));
        User user = new User();
        user.setUserId(id);
        user.setUsername(username);
        user.setRating(rating);
        user.setNumberOfVisits(numberOfVisits);
        user.setCurrentVisitingTime(new Date(new java.util.Date().getTime()));
        UserDAO userDAO = new UserDAO();
        try {
            if (id == 0){
                userDAO.add(user);
            } else userDAO.update(user);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<User> users = null;
        try {
            users = userDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/get-users-jsp.jsp");
        requestDispatcher.forward(request, response);


    }

    public void destroy() {
    }
}