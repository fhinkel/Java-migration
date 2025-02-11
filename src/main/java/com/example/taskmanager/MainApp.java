package com.example.taskmanager;

import java.util.Date;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask("Prepare presentation slides for team meeting", new Date());
        taskManager.addTask("Respond to client emails", new Date());
        String codeReviewTaskId = taskManager.addTask("Code review pull request from John", new Date());
        taskManager.addTask("Write documentation for new feature", new Date());
        taskManager.addTask("Schedule meeting with marketing team", new Date());
        taskManager.addTask("Finalize budget report", new Date());
        taskManager.addTask("Plan next sprint backlog", new Date());
        taskManager.addTask("Update project dependencies", new Date());


        // Mark one task as complete 
        taskManager.markComplete(codeReviewTaskId);

        // List all tasks
        List<Task> allTasks = taskManager.getAllTasks();
        System.out.println("Work Tasks:");
        for (Task task : allTasks) {
            System.out.println("- " + task.getDescription() + (task.isCompleted() ? " (Completed)" : " (Pending)"));
        }
    }
}