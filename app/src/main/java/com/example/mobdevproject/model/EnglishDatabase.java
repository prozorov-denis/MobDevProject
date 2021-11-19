package com.example.mobdevproject.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {Topic.class, Exercise.class, Statistics.class},
        version = 1
)
public abstract class EnglishDatabase extends RoomDatabase {
    public abstract EnglishDAO englishDAO();

    private static EnglishDatabase instance;

    public static EnglishDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        EnglishDatabase.class,
                        "EnglishDb"
                    )
                    .allowMainThreadQueries()
                    .build();

            instance.populateInitialData();
        }

        return instance;
    }

    private void populateInitialData() {
        if (englishDAO().getAllTopicsList().size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    englishDAO().insertTopic(new Topic("Present Simple"));
                    englishDAO().insertTopic(new Topic("Past Simple"));
                    englishDAO().insertTopic(new Topic("Future Simple"));

                    englishDAO().insertTopic(new Topic("Present Continuous"));
                    englishDAO().insertTopic(new Topic("Past Continuous"));
                    englishDAO().insertTopic(new Topic("Future Continuous"));

                    englishDAO().insertTopic(new Topic("Present Perfect"));
                    englishDAO().insertTopic(new Topic("Past Perfect"));
                    englishDAO().insertTopic(new Topic("Future Perfect"));

                    englishDAO().insertTopic(new Topic("Present Perfect Continuous"));
                    englishDAO().insertTopic(new Topic("Past Perfect Continuous"));
                    englishDAO().insertTopic(new Topic("Future Perfect Continuous"));
                }
            });
        }
    }
}
