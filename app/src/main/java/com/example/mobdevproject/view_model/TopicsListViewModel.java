package com.example.mobdevproject.view_model;

import androidx.lifecycle.ViewModel;

import com.example.mobdevproject.model.Topic;

import java.util.ArrayList;

public class TopicsListViewModel extends ViewModel {
    private ArrayList<Topic> topics_list;

    public TopicsListViewModel() {
        topics_list = new ArrayList<Topic>();

        for (int i = 1; i <= 10; i++) {
            topics_list.add(new Topic(i,"Topic " + i));
        }
    }

    public ArrayList<Topic> getTopics_list() {
        return topics_list;
    }
}