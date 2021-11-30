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

    public long getMsAverage() {
        return msAverage;
    }

    public void setMsAverage(long ms) {
        this.msAverage = ms;
    }

    public int getResultAverage() {
        return resultAverage;
    }

    public void setResultAverage(int result) {
        this.resultAverage = result;
    }

    public long getMsBest() {
        return msBest;
    }

    public void setMsBest(long ms) {
        this.msBest = ms;
    }

    public int getResultBest() {
        return resultBest;
    }

    public void setResultBest(int result) {
        this.resultBest = result;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "msAverage")
    private long msAverage;

    @ColumnInfo(name = "resultAverage")
    private int resultAverage;

    @ColumnInfo(name = "msBest")
    private long msBest;

    @ColumnInfo(name = "resultBest")
    private int resultBest;
}
