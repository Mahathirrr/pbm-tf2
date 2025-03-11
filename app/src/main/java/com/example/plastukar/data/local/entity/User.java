package com.example.plastukar.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    private String id;
    private String name;
    private String email;
    private String profileImage;
    private int points;
    private int level;
    private int totalPlasticCollected;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.points = 0;
        this.level = 1;
        this.totalPlasticCollected = 0;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
    
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
    
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    
    public int getTotalPlasticCollected() { return totalPlasticCollected; }
    public void setTotalPlasticCollected(int totalPlasticCollected) { 
        this.totalPlasticCollected = totalPlasticCollected; 
    }
}