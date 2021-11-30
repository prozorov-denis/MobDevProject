package com.example.mobdevproject.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.example.mobdevproject.model.EnglishAppDatabase;
import com.example.mobdevproject.model.Statistics;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StatisticsViewModel extends AndroidViewModel {
    private EnglishAppDatabase db;
    private Statistics statistics;

    public StatisticsViewModel(@NonNull Application application) {
        super(application);
        db = EnglishAppDatabase.getInstance(application);

        List<Statistics> statisticsList = db.englishDAO().getAllStatisticsList();
        if (statisticsList.size() > 0)
            statistics = db.englishDAO().getAllStatisticsList().get(0);
        else
            statistics = new Statistics();
    }

    public void UpdateStatistics(int result, long ms) {
        if (result > 50) {
            List<Statistics> statisticsList = db.englishDAO().getAllStatisticsList();

            if (statisticsList.size() > 0) {
                Statistics statistics = db.englishDAO().getAllStatisticsList().get(0);

                statistics.setMsAverage((statistics.getMsAverage() + ms) / 2);
                statistics.setResultAverage((statistics.getResultAverage() + result) / 2);

                if (statistics.getMsBest() > ms)
                    statistics.setMsBest(ms);

                if (statistics.getResultBest() < result)
                    statistics.setResultBest(result);

                db.englishDAO().updateStatistics(statistics);
            }
            else {
                Statistics statistics = new Statistics();
                statistics.setMsAverage(ms);
                statistics.setResultAverage(result);
                statistics.setMsBest(ms);
                statistics.setResultBest(result);
                db.englishDAO().insertStatistics(statistics);
            }
        }
    }

    public String getAverageResult() {
        if (statistics != null)
            return statistics.getResultAverage() + "%";
        else
            return "";
    }

    public String getBestResult() {
        if (statistics != null)
            return statistics.getResultBest() + "%";
        else
            return "";
    }

    public String getAverageTime() {
        if (statistics != null) {
            long minutes = TimeUnit.MILLISECONDS.toMinutes(statistics.getMsAverage());
            long seconds = TimeUnit.MILLISECONDS.toSeconds(statistics.getMsAverage()) - TimeUnit.MINUTES.toSeconds(minutes);

            String minutes_str;

            if (minutes < 10)
                minutes_str = "0" + minutes;
            else
                minutes_str = "" + minutes;

            String seconds_str;

            if (seconds < 10)
                seconds_str = "0" + seconds;
            else
                seconds_str = "" + seconds;

            String time = minutes_str + ":" + seconds_str;

            return time;
        }
        else
            return "";
    }

    public String getBestTime() {
        if (statistics != null) {
            long minutes = TimeUnit.MILLISECONDS.toMinutes(statistics.getMsBest());
            long seconds = TimeUnit.MILLISECONDS.toSeconds(statistics.getMsBest()) - TimeUnit.MINUTES.toSeconds(minutes);

            String minutes_str;

            if (minutes < 10)
                minutes_str = "0" + minutes;
            else
                minutes_str = "" + minutes;

            String seconds_str;

            if (seconds < 10)
                seconds_str = "0" + seconds;
            else
                seconds_str = "" + seconds;

            String time = minutes_str + ":" + seconds_str;

            return time;
        }
        else
            return "";
    }


}
