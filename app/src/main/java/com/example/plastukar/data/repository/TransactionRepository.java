package com.example.plastukar.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.plastukar.data.local.dao.TransactionDao;
import com.example.plastukar.data.local.database.AppDatabase;
import com.example.plastukar.data.local.entity.Transaction;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionRepository {
    private final TransactionDao transactionDao;
    private final ExecutorService executorService;

    public TransactionRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        transactionDao = db.transactionDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<Transaction>> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    public LiveData<List<Transaction>> getTransactionsByUser(String userId) {
        return transactionDao.getTransactionsByUser(userId);
    }

    public void insert(Transaction transaction) {
        executorService.execute(() -> transactionDao.insert(transaction));
    }

    public void update(Transaction transaction) {
        executorService.execute(() -> transactionDao.update(transaction));
    }

    public void delete(Transaction transaction) {
        executorService.execute(() -> transactionDao.delete(transaction));
    }

    public LiveData<Integer> getTotalPoints(String userId) {
        return transactionDao.getTotalPoints(userId);
    }
}
