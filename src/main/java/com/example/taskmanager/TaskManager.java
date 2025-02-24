package com.example.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Date;

/**
 * The TaskManager class is responsible for managing a collection of Task objects.
 * It provides methods to add, retrieve, and mark tasks as complete.
 */
public class TaskManager {
    private List<Task> tasks;

    /**
     * Constructs a new TaskManager object, initializing the internal list of tasks.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

        /**
     * Adds a new task to the task manager.
     *
     * @param description The description of the task.
     * @param dueDate     The due date of the task.
     * @return The unique ID assigned to the newly created task.
     */
    public String addTask(String description, Date dueDate) {
        String taskId = UUID.randomUUID().toString();
        Task task = new Task(taskId, description, dueDate);
        tasks.add(task);
        return taskId;
    }

    /**
     * Retrieves a list of all tasks managed by this TaskManager.
     *
     * @return A List containing all tasks. A copy of the internal list is returned to prevent external modifications.
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks); // Return a copy to avoid external modification
    }

    /**
     * Marks a task as complete.
     *
     * @param taskId The ID of the task to mark as complete.
     * @return True if the task was found and marked as complete, false otherwise.
     */
    public boolean markComplete(String taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(taskId)) {
                tasks.get(i).setCompleted(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a task by its ID.
     *
     * @param taskId The ID of the task to find.
     * @return The Task object if found, null otherwise.
     */
    public Task findTaskById(String taskId) {
        for (int i = 0; i < tasks.size(); i++)  {
            if (tasks.get(i).getId().equals(taskId)) {
                return tasks.get(i);
            }
        }
        return null;
    }
}