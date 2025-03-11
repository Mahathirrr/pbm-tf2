package com.example.plastukar.data.local.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.plastukar.data.local.dao.ChallengeDao;
import com.example.plastukar.data.local.dao.TransactionDao;
import com.example.plastukar.data.local.dao.UserDao;
import com.example.plastukar.data.local.entity.Challenge;
import com.example.plastukar.data.local.entity.Transaction;
import com.example.plastukar.data.local.entity.User;
import com.example.plastukar.utils.Converters;

@Database(
        entities = {
                User.class,
                Transaction.class,
                Challenge.class
        },
        version = 1,
        exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract TransactionDao transactionDao();
    public abstract ChallengeDao challengeDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "plastukar_database"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
