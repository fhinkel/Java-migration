package com.example.taskmanager;

import java.util.Date;

public record Task(
    String id, 
    String description, 
    Date dueDate, 
    boolean completed
) { }