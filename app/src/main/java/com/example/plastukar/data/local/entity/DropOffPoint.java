package com.example.plastukar.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drop_off_points")
public class DropOffPoint {
    @PrimaryKey
    private String id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String operatingHours;
    private boolean isOpen;
    private String acceptedTypes;

    public DropOffPoint(String id, String name, String address, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getOperatingHours() { return operatingHours; }
    public void setOperatingHours(String operatingHours) { this.operatingHours = operatingHours; }

    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean open) { isOpen = open; }

    public String getAcceptedTypes() { return acceptedTypes; }
    public void setAcceptedTypes(String acceptedTypes) { this.acceptedTypes = acceptedTypes; }
}