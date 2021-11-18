package com.example.mobdevproject.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mobdevproject.model.EnglishDatabase;
import com.example.mobdevproject.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicsViewModel extends AndroidViewModel {
    private EnglishDatabase db;
    private List<Topic> topics;

    public TopicsViewModel(@NonNull Application application) {
        super(application);

        db = EnglishDatabase.getDBInstance(application);
        topics = db.englishDAO().getAllTopicsList();
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }
}
