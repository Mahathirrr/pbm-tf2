package com.example.plastukar.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.plastukar.data.local.entity.Challenge;

import java.util.List;

@Dao
public interface ChallengeDao {
    @Query("SELECT * FROM challenges")
    LiveData<List<Challenge>> getAllChallenges();

    @Query("SELECT * FROM challenges WHERE type = :type")
    LiveData<List<Challenge>> getChallengesByType(String type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Challenge challenge);

    @Update
    void update(Challenge challenge);

    @Delete
    void delete(Challenge challenge);

    @Query("SELECT * FROM challenges WHERE isCompleted = 0")
    LiveData<List<Challenge>> getActiveChallenges();

    @Query("UPDATE challenges SET progress = progress + :amount WHERE id = :challengeId")
    void updateProgress(String challengeId, int amount);
}
