package com.example.MongoDBplayground;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestUser {
    final private String userId;
    final private String id;
    final private String title;
    final private boolean completed;

    public TestUser(@JsonProperty("userId") String userId,
                    @JsonProperty("id") String id,
                    @JsonProperty("title") String title,
                    @JsonProperty("completed") boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;


    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
