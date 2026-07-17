package com.hotel.servlet;

import java.io.IOException;

import com.hotel.dao.UserDAO;
import com.hotel.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        UserDAO dao = new UserDAO();

        if (dao.emailExists(email)) {

            response.sendRedirect(
                    "register.jsp?msg=email_exists"
            );

            return;
        }

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        if (dao.registerUser(user)) {

            response.sendRedirect(
                    "login.jsp?msg=registered"
            );

        } else {

            response.sendRedirect(
                    "register.jsp?msg=error"
            );

        }
    }
}
