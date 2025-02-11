package com.example.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Date;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public String addTask(String description, Date dueDate) {
        String taskId = UUID.randomUUID().toString();
        Task task = new Task(taskId, description, dueDate);
        tasks.add(task);
        return taskId;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks); // Return a copy to avoid external modification
    }

    public boolean markComplete(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                return true;
            }
        }
        return false;
    }

    public Task findTaskById(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }
}