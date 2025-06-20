package com.example.taskmanager;

import java.util.Date;

public class Task {
    private String id;
    private String description;
    private Date dueDate;
    private boolean completed;
    private int timeToComplete;

    public Task(String id, String description, Date dueDate, int timeToComplete) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.timeToComplete = timeToComplete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
}