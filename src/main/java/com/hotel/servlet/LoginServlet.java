package com.hotel.servlet;

import java.io.IOException;

import com.hotel.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        UserDAO dao = new UserDAO();

        if (dao.loginUser(email, password)) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "email",
                    email
            );

            response.sendRedirect(
                    "dashboard.jsp"
            );

        } else {

            response.sendRedirect(
                    "login.jsp?msg=invalid"
            );

        }
    }
}