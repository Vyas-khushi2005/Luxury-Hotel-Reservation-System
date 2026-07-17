package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hotel.model.Room;

public class RoomDAO {

    public ArrayList<Room> getAllRooms() {

        ArrayList<Room> rooms = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from rooms";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Room room = new Room();

                room.setRoomId(rs.getInt("room_id"));
                room.setRoomName(rs.getString("room_name"));
                room.setPrice(rs.getDouble("price"));
                room.setDescription(rs.getString("description"));
                room.setImage(rs.getString("image"));

                rooms.add(room);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }
}