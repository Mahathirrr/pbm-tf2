package com.example.plastukar.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class Transaction {
    @PrimaryKey
    private String id;
    private String userId;
    private String type; // DEPOSIT, REDEEM
    private int points;
    private long timestamp;
    private String description;
    private String location;
    private double plasticWeight;
    private String plasticType;
    private String status;

    public Transaction(String id, String userId, String type, int points) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.points = points;
        this.timestamp = System.currentTimeMillis();
        this.status = "COMPLETED";
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPlasticWeight() { return plasticWeight; }
    public void setPlasticWeight(double plasticWeight) { this.plasticWeight = plasticWeight; }

    public String getPlasticType() { return plasticType; }
    public void setPlasticType(String plasticType) { this.plasticType = plasticType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}