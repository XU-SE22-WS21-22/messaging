package com.example.messaging.model;

import java.util.Date;

public class NotificationTask {
    private long id;
    private String title;
    private String description;
    private String url;
    private Date deadline;

    public NotificationTask(long id, String title, String description, String url, Date deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


}
