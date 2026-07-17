package com.hotel.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hotel.dao.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "select * from admin where email=? and password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession session =
                        request.getSession();

                session.setAttribute(
                        "admin",
                        email
                );

                response.sendRedirect(
                        "adminDashboard.jsp"
                );

            } else {

                response.getWriter()
                        .println("Invalid Admin Login");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}