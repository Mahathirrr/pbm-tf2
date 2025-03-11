package com.example.plastukar.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "challenges")
public class Challenge {
    @PrimaryKey
    private String id;
    private String title;
    private String description;
    private int pointsReward;
    private String type; // DAILY, WEEKLY, SPECIAL
    private long startDate;
    private long endDate;
    private boolean isCompleted;
    private int progress;
    private int targetProgress;

    public Challenge(String id, String title, String description, int pointsReward) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pointsReward = pointsReward;
        this.isCompleted = false;
        this.progress = 0;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPointsReward() { return pointsReward; }
    public void setPointsReward(int pointsReward) { this.pointsReward = pointsReward; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public long getStartDate() { return startDate; }
    public void setStartDate(long startDate) { this.startDate = startDate; }

    public long getEndDate() { return endDate; }
    public void setEndDate(long endDate) { this.endDate = endDate; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }

    public int getTargetProgress() { return targetProgress; }
    public void setTargetProgress(int targetProgress) { this.targetProgress = targetProgress; }
}