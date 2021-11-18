package com.example.mobdevproject.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {Topic.class, Exercise.class, Statistics.class},
        version = 1
)
public abstract class EnglishDatabase extends RoomDatabase {
    public abstract EnglishDAO englishDAO();

    public static EnglishDatabase INSTANCE;

    public static EnglishDatabase getDBInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        EnglishDatabase.class,
                        "EnglishDb"
                    )
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }
}
