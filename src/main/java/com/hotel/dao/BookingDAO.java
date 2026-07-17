package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hotel.model.Booking;

public class BookingDAO {

    public boolean bookRoom(Booking booking) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "insert into bookings(user_name,room_type,check_in,check_out,price) values(?,?,?,?,?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, booking.getUserName());
            ps.setString(2, booking.getRoomType());
            ps.setString(3, booking.getCheckIn());
            ps.setString(4, booking.getCheckOut());
            ps.setDouble(5, booking.getPrice());

            int row = ps.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public ArrayList<Booking> getAllBookings() {

        ArrayList<Booking> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "select * from bookings order by booking_id desc";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking b = new Booking();

                b.setBookingId(
                        rs.getInt("booking_id"));

                b.setUserName(
                        rs.getString("user_name"));

                b.setRoomType(
                        rs.getString("room_type"));

                b.setCheckIn(
                        rs.getString("check_in"));

                b.setCheckOut(
                        rs.getString("check_out"));

                b.setPrice(
                        rs.getDouble("price"));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}