package com.example.mobdevproject.view_model;

import androidx.lifecycle.ViewModel;


import com.example.mobdevproject.model.Exercise;

import java.util.ArrayList;

public class TestViewModel extends ViewModel {
    private ArrayList<Exercise> exercises_list;
    private String time;

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

        n_all = countExercises(); // 6

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int countExercises()
    {
        return exercises_list.size();
    }

}
