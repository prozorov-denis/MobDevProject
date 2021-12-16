package com.example.mobdevproject.view_model;

//import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestViewModel {//extends ViewModel {
    private ArrayList<Exercise> exercises_list;
    private String time;
    private long ms_time;

    public TestViewModel() {
        exercises_list = new ArrayList<Exercise>();
    }

    public TestViewModel(ArrayList<Exercise> exercises_list) {
        this.exercises_list = exercises_list;
    }

    public ArrayList<Exercise> getExercises_list() {
        return exercises_list;
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

    public String getMark() { // 1
        int n_correct = 0;
        int n_all = 0;
        double mark_double = 0;
        String mark_string = "";

        n_correct = countCorrectAnswers();
        n_all = countExercises();

        if (n_all > 0) {// 2
            mark_double = (double) n_correct / n_all * 100; // 3

            if (mark_double >= 90) // 4
                mark_string = "Отлично"; // 5
            else if (mark_double >= 70) // 6
                mark_string = "Хорошо"; // 7
            else if (mark_double >= 50) // 8
                mark_string = "Удовлетворительно"; // 9
            else
                mark_string = "Неудовлетворительно"; // 10
        }   else {
            mark_string = "Ошибка"; // 11
        }

        return mark_string; // 12
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

    public void setMs(long ms) {
        this.ms_time = ms;
    }

    public int countExercises()
    {
        return exercises_list.size();
    }

}
