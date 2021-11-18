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

    @Ignore
    private String answer;

    public Exercise(int topicId, String task, String correctAnswer) {
        this.topicId = topicId;
        this.task = task;
        this.correctAnswer = correctAnswer;
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
}
