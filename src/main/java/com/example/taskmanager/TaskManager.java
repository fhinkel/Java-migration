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
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(taskId)) {
                tasks.get(i).setCompleted(true);
                return true;
            }
        }
        return false;
    }

    public Task findTaskById(String taskId) {
        for (int i = 0; i < tasks.size(); i++)  {
            if (tasks.get(i).getId().equals(taskId)) {
                return tasks.get(i);
            }
        }
        return null;
    }

    public long calculateTotalTimeRemaining() {
        long totalTimeRemaining = 0;
        Date now = new Date();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                long diff = task.getDueDate().getTime() - now.getTime();
                if (diff > 0) {
                    totalTimeRemaining += diff;
                }
            }
        }
        return totalTimeRemaining;
    }
}