package com.example.mobdevproject.model;

public class Topic {
    private int topicId;
    private String title;

    public Topic(int topicId, String title) {
        this.topicId = topicId;
        this.title = title;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
