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
        String taskId = taskManager.addTask("Buy groceries", dueDate);
        assertNotNull(taskId);
        Task task = taskManager.findTaskById(taskId);
        assertNotNull(task);
        assertEquals("Buy groceries", task.getDescription());
        assertEquals(dueDate, task.getDueDate());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testCalculateTotalTimeRemaining() {
        Date now = new Date();
        taskManager.addTask("Task 1", new Date(now.getTime() + 3600000)); // 1 hour from now
        taskManager.addTask("Task 2", new Date(now.getTime() + 7200000)); // 2 hours from now
        long totalTimeRemaining = taskManager.calculateTotalTimeRemaining();
        assertTrue(totalTimeRemaining > 0);
    }

    // You can add more tests here
}