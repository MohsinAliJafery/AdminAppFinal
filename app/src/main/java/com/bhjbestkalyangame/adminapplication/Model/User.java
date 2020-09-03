package com.bhjbestkalyangame.adminapplication.Model;

public class User {

    private String ID, Username, ImageUrl;

    public User(String userID, String username, String imageUrl) {
        ID = userID;
        Username = username;
        ImageUrl = imageUrl;
    }

    public User() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}

