package com.example.taskmanager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        Date dueDate = new Date();
        String taskId = taskManager.addTask("Buy groceries", dueDate, 60);
        assertNotNull(taskId);
        Task task = taskManager.findTaskById(taskId);
        assertNotNull(task);
        assertEquals("Buy groceries", task.getDescription());
        assertEquals(dueDate, task.getDueDate());
        assertFalse(task.isCompleted());
        assertEquals(60, task.getTimeToComplete());
    }

    @Test
    public void testCalculateTotalTimeToComplete() {
        Date dueDate = new Date();
        taskManager.addTask("Task 1", dueDate, 30);
        taskManager.addTask("Task 2", dueDate, 45);
        String taskId3 = taskManager.addTask("Task 3", dueDate, 60);

        assertEquals(135, taskManager.calculateTotalTimeToComplete());

        taskManager.markComplete(taskId3);

        assertEquals(75, taskManager.calculateTotalTimeToComplete());
    }
}
