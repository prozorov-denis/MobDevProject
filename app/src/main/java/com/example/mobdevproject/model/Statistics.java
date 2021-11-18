package com.example.mobdevproject.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Statistics {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "seconds")
    public int seconds;

    @ColumnInfo(name = "result")
    public int result;
}
