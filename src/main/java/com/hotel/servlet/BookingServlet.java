package com.hotel.servlet;

import java.io.IOException;

import com.hotel.dao.BookingDAO;
import com.hotel.model.Booking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String userName =
                request.getParameter("userName");

        String roomType =
                request.getParameter("roomType");

        String checkIn =
                request.getParameter("checkIn");

        String checkOut =
                request.getParameter("checkOut");

        double price = 0;

        if(roomType.equals("Standard Room")) {
            price = 1500;
        }
        else if(roomType.equals("Deluxe Room")) {
            price = 3000;
        }
        else {
            price = 5000;
        }

        Booking booking = new Booking();

        booking.setUserName(userName);
        booking.setRoomType(roomType);
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setPrice(price);

        BookingDAO dao = new BookingDAO();

        if (dao.bookRoom(booking)) {

            response.sendRedirect(
                    "myBookings.jsp?msg=success");

        } else {

            response.sendRedirect(
                    "bookRoom.jsp?msg=error");
        }
    }
}