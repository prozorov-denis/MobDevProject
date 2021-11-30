package com.example.mobdevproject.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyAppEnglishDAO {
    @Query("SELECT * FROM Topic")
    List<Topic> getAllTopicsList();

    @Query("SELECT * FROM Topic WHERE title = :title")
    Topic getTopicByTitle(String title);

    @Insert
    void insertTopic(Topic...topics);

    @Update
    void updateTopic(Topic topic);

    @Delete
    void deleteTopic(Topic topic);

    @Query("SELECT * FROM Exercise")
    List<Exercise> getAllExercisesList();

    @Query("SELECT * FROM Exercise WHERE topicId = :topicId")
    List<Exercise> getExercisesListForTopic(int topicId);

    @Insert
    void insertExercise(Exercise...topics);

    @Update
    void updateExercise(Exercise topic);

    @Delete
    void deleteExercise(Exercise topic);

    @Query("SELECT * FROM Statistics")
    List<Statistics> getAllStatisticsList();

    @Insert
    void insertStatistics(Statistics...topics);

    @Update
    void updateStatistics(Statistics topic);

    @Delete
    void deleteStatistics(Statistics topic);
}
