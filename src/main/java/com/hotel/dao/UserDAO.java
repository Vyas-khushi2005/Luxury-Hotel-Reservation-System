package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hotel.model.User;

public class UserDAO {

    public boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "insert into users(name,email,password) values(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int row = ps.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;
    }

    public boolean loginUser(String email,
                             String password) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "select * from users where email=? and password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            if (ps.executeQuery().next()) {
                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;
    }

    public boolean emailExists(String email) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "select * from users where email=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, email);

            if (ps.executeQuery().next()) {
                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;
    }
}