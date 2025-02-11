package com.example.taskmanager;

import java.util.Date;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Add some tasks
        taskManager.addTask("Write user study tasks", new Date());
        taskManager.addTask("Prepare codebase for study", new Date());
        String taskId = taskManager.addTask("Run user study", new Date());

        // Mark one task as complete
        taskManager.markComplete(taskId);

        // List all tasks
        List<Task> allTasks = taskManager.getAllTasks();
        System.out.println("All Tasks:");
        for (Task task : allTasks) {
            System.out.println("- " + task.getDescription() + (task.isCompleted() ? " (Completed)" : " (Pending)"));
        }
    }
}