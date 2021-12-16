package com.example.mobdevproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.example.mobdevproject.view_model.Exercise;
import com.example.mobdevproject.view_model.TestViewModel;

import java.util.ArrayList;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Test
    public void a_mark_test_mock() {
        TestViewModel testViewModel = new TestViewModel();
        TestViewModel spyTestViewModel = Mockito.spy(testViewModel);

        when(spyTestViewModel.countCorrectAnswers()).thenReturn(10);
        when(spyTestViewModel.countExercises()).thenReturn(10);

        assertEquals("Отлично", spyTestViewModel.getMark());
    }

    @Test
    public void b_mark_test_mock() {
        TestViewModel testViewModel = new TestViewModel();
        TestViewModel spyTestViewModel = Mockito.spy(testViewModel);

        when(spyTestViewModel.countCorrectAnswers()).thenReturn(7);
        when(spyTestViewModel.countExercises()).thenReturn(10);

        assertEquals("Хорошо", spyTestViewModel.getMark());
    }

    @Test
    public void c_mark_test_mock() {
        TestViewModel testViewModel = new TestViewModel();
        TestViewModel spyTestViewModel = Mockito.spy(testViewModel);

        when(spyTestViewModel.countCorrectAnswers()).thenReturn(5);
        when(spyTestViewModel.countExercises()).thenReturn(10);

        assertEquals("Удовлетворительно", spyTestViewModel.getMark());
    }

    @Test
    public void d_mark_test_mock() {
        TestViewModel testViewModel = new TestViewModel();
        TestViewModel spyTestViewModel = Mockito.spy(testViewModel);

        when(spyTestViewModel.countCorrectAnswers()).thenReturn(2);
        when(spyTestViewModel.countExercises()).thenReturn(10);

        assertEquals("Неудовлетворительно", spyTestViewModel.getMark());
    }

    @Test
    public void error_mark_test_mock() {
        TestViewModel testViewModel = new TestViewModel();
        TestViewModel spyTestViewModel = Mockito.spy(testViewModel);

        when(spyTestViewModel.countCorrectAnswers()).thenReturn(10);
        when(spyTestViewModel.countExercises()).thenReturn(0);

        assertEquals("Ошибка", spyTestViewModel.getMark());
    }

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

    @Test
    public void time_test1() {
        TestViewModel testViewModel = new TestViewModel();

        testViewModel.setMs(1000);

        assertEquals("00:01", testViewModel.getTime());
    }

    @Test
    public void time_test2() {
        TestViewModel testViewModel = new TestViewModel();

        testViewModel.setMs(10000);

        assertEquals("00:10", testViewModel.getTime());
    }

    @Test
    public void time_test3() {
        TestViewModel testViewModel = new TestViewModel();

        testViewModel.setMs(60000);

        assertEquals("01:00", testViewModel.getTime());
    }

    @Test
    public void time_test4() {
        TestViewModel testViewModel = new TestViewModel();

        testViewModel.setMs(600000);

        assertEquals("10:00", testViewModel.getTime());
    }

    @Test
    public void time_test5() {
        TestViewModel testViewModel = new TestViewModel();

        testViewModel.setMs(610000);

        assertEquals("10:10", testViewModel.getTime());
    }
}