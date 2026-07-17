package com.hotel.model;

public class Room {

    private int roomId;
    private String roomName;
    private double price;
    private String description;
    private String image;

    public Room() {
    }

    public Room(int roomId, String roomName, double price,
                String description, String image) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}