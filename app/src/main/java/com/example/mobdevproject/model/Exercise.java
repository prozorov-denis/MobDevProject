package com.example.mobdevproject.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "topicId")
    private int topicId;

    @ColumnInfo(name = "task")
    private String task;

    @ColumnInfo(name = "correctAnswer")
    private String correctAnswer;

    @ColumnInfo(name = "hasMultipleChoice")
    private boolean hasMultipleChoice;

    @ColumnInfo(name = "answer1")
    private String answer1;

    @ColumnInfo(name = "answer2")
    private String answer2;

    @ColumnInfo(name = "answer3")
    private String answer3;

    @Ignore
    private String answer;

    public Exercise(int topicId, String task, String answer1, String answer2, String answer3, String correctAnswer, boolean hasMultipleChoice) {
        this.topicId = topicId;
        this.task = task;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
        this.hasMultipleChoice = hasMultipleChoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public boolean getHasMultipleChoice() {
        return hasMultipleChoice;
    }

    public void setHasMultipleChoice(boolean has) {
        this.hasMultipleChoice = has;
    }
}
