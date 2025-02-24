package com.example.taskmanager;

import java.util.Date;

public record Task(
    String id, 
    String description, 
    Date dueDate, 
    boolean completed, 
    int pendingTime
) { 
    public Task(String id, String description, Date dueDate, boolean completed) {
        this(id, description, dueDate, completed, (int)Math.max(0, (dueDate.getTime() - new Date().getTime()) / (1000 * 60)));
    }
}
