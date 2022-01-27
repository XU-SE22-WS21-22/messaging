package com.example.messaging.model;

public class NotifiTask {
    private final long id;
    private final String content;

    public NotifiTask(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
