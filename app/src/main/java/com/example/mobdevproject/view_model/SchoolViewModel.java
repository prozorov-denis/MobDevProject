package com.example.mobdevproject.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mobdevproject.model.Exercise;
import com.example.mobdevproject.model.EnglishAppDatabase;
import com.example.mobdevproject.model.Statistics;
import com.example.mobdevproject.model.Topic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchoolViewModel extends AndroidViewModel {
    private EnglishAppDatabase db;
    private List<Topic> topics;
    private Topic currentTopic;

    private ArrayList<Exercise> exercises_list;
    private long ms_time;

    public SchoolViewModel(@NonNull Application application) {
        super(application);

        db = EnglishAppDatabase.getInstance(application);
        topics = db.englishDAO().getAllTopicsList();
        currentTopic = topics.get(0);
        exercises_list = new ArrayList<Exercise>();
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void setCurrentTopic(String title) {
        for (Topic t: topics) {
            if (t.getTitle().equalsIgnoreCase(title)) {
                currentTopic = t;
                setExercisesForTopic(currentTopic);
                return;
            }
        }
    }

    public void setExercisesForTopic(Topic topic) {
        int n = 10;

        List<Exercise> exListAll = db.englishDAO().getExercisesListForTopic(topic.getId());
        //Collections.shuffle(exListAll);

        if (n > exListAll.size())
            n = exListAll.size();

        exercises_list.clear();
        for (int i = 0; i < n; i++)
            exercises_list.add(exListAll.get(i));

        for (Exercise e: exercises_list) {
            e.setAnswer("");
        }
    }

    public List<Exercise> getExercises_list() {
        return exercises_list;
    }

    public void setExercises_list(ArrayList<Exercise> exercises_list) {
        this.exercises_list = exercises_list;
    }

    public String getTime() { // 1
        long minutes = TimeUnit.MILLISECONDS.toMinutes(ms_time);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(ms_time) - TimeUnit.MINUTES.toSeconds(minutes);

        String minutes_str;

        if (minutes < 10) // 2
            minutes_str = "0" + minutes; // 3
        else
            minutes_str = "" + minutes; // 4

        String seconds_str;

        if (seconds < 10) // 5
            seconds_str = "0" + seconds; // 6
        else
            seconds_str = "" + seconds; // 7

        return minutes_str + ":" + seconds_str; // 8
    }

    public int countCorrectAnswers() {
        int n = 0;

        for (Exercise ex : exercises_list) {
            if (ex.getAnswer().equalsIgnoreCase(ex.getCorrectAnswer()))
                n++;
        }

        return n;
    }

    public int getResult() {
        double percent_d;
        int percent_i;

        if (exercises_list.size() == 0) {
            return 0;
        }

        percent_d = ((double) countCorrectAnswers()) * 100 / exercises_list.size();
        percent_i = (int)percent_d;

        return percent_i;
    }

    public long getMs_time() {
        return ms_time;
    }

    public void setMs_time(long ms_time) {
        this.ms_time = ms_time;
    }

    public String getMark() { // 1
        int n_correct = 0;
        int n_all = 0;
        double mark_double = 0;
        String mark_string = "";

        n_correct = countCorrectAnswers();

        n_all = exercises_list.size(); // 6

        if (n_all > 0) {// 7
            mark_double = (double) n_correct / n_all * 100; // 8

            if (mark_double >= 90) // 9
                mark_string = "Отлично"; // 10
            else if (mark_double >= 70) // 11
                mark_string = "Хорошо"; // 12
            else if (mark_double >= 50) // 13
                mark_string = "Удовлетворительно"; // 14
            else
                mark_string = "Неудовлетворительно"; // 15
        }   else {
            mark_string = "Ошибка"; // 16
        }

        return mark_string; // 17
    }
}
