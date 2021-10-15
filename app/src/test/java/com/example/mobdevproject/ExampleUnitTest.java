package com.example.mobdevproject;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.mobdevproject.model.Exercise;
import com.example.mobdevproject.view_model.TestViewModel;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void a_mark_test() {
        TestViewModel testViewModel;

        ArrayList<Exercise> exercises_list = new ArrayList<Exercise>();

        for (int i = 1; i <= 10; i++) {
            Exercise exercise = new Exercise(i,"Question " + i, "Answer " + i);
            exercise.setAnswer(exercise.getCorrectAnswer());
            exercises_list.add(exercise);
        }

        testViewModel = new TestViewModel(exercises_list);

        assertEquals("Отлично", testViewModel.getMark());
    }

    @Test
    public void b_mark_test() {
        TestViewModel testViewModel;

        ArrayList<Exercise> exercises_list = new ArrayList<Exercise>();

        for (int i = 1; i <= 7; i++) {
            Exercise exercise = new Exercise(i,"Question " + i, "Answer " + i);
            exercise.setAnswer(exercise.getCorrectAnswer());
            exercises_list.add(exercise);
        }

        for (int i = 8; i <= 10; i++) {
            Exercise exercise = new Exercise(i,"Question " + i, "Answer " + i);
            exercise.setAnswer("Incorrect");
            exercises_list.add(exercise);
        }

        testViewModel = new TestViewModel(exercises_list);

        assertEquals("Хорошо", testViewModel.getMark());
    }

    @Test
    public void c_mark_test() {
        TestViewModel testViewModel;

        ArrayList<Exercise> exercises_list = new ArrayList<Exercise>();

        for (int i = 1; i <= 5; i++) {
            Exercise exercise = new Exercise(i,"Question " + i, "Answer " + i);
            exercise.setAnswer(exercise.getCorrectAnswer());
            exercises_list.add(exercise);
        }

        for (int i = 6; i <= 10; i++) {
            Exercise exercise = new Exercise(i,"Question " + i, "Answer " + i);
            exercise.setAnswer("Incorrect");
            exercises_list.add(exercise);
        }

        testViewModel = new TestViewModel(exercises_list);

        assertEquals("Удовлетворительно", testViewModel.getMark());
    }

    @Test
    public void d_mark_test() {
        TestViewModel testViewModel;

        ArrayList<Exercise> exercises_list = new ArrayList<Exercise>();

        for (int i = 1; i <= 10; i++) {
            Exercise exercise = new Exercise(i,"Question " + i, "Answer " + i);
            exercise.setAnswer("Incorrect");
            exercises_list.add(exercise);
        }

        testViewModel = new TestViewModel(exercises_list);

        assertEquals("Неудовлетворительно", testViewModel.getMark());
    }

    @Test
    public void error_mark_test() {
        TestViewModel testViewModel;

        ArrayList<Exercise> exercises_list = new ArrayList<Exercise>();

        testViewModel = new TestViewModel(exercises_list);

        assertEquals("Ошибка", testViewModel.getMark());
    }
}