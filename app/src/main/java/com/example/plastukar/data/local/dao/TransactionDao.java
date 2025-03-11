package com.example.plastukar.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.plastukar.data.local.entity.Transaction;

import java.util.List;

@Dao
public interface TransactionDao {
    @Query("SELECT * FROM transactions ORDER BY timestamp DESC")
    LiveData<List<Transaction>> getAllTransactions();

    @Query("SELECT * FROM transactions WHERE userId = :userId ORDER BY timestamp DESC")
    LiveData<List<Transaction>> getTransactionsByUser(String userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Transaction transaction);

    @Update
    void update(Transaction transaction);

    @Delete
    void delete(Transaction transaction);

    @Query("SELECT * FROM transactions WHERE type = :type AND userId = :userId")
    LiveData<List<Transaction>> getTransactionsByType(String type, String userId);

    @Query("SELECT SUM(points) FROM transactions WHERE userId = :userId AND type = 'DEPOSIT'")
    LiveData<Integer> getTotalPoints(String userId);
}
