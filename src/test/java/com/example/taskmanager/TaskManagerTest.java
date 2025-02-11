package com.example.taskmanager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

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
    public void testGetAllTasks() {
        taskManager.addTask("Task 1", new Date());
        taskManager.addTask("Task 2", new Date());
        List<Task> tasks = taskManager.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void testMarkComplete() {
        String taskId = taskManager.addTask("Task to complete", new Date());
        boolean marked = taskManager.markComplete(taskId);
        assertTrue(marked);
        Task task = taskManager.findTaskById(taskId);
        assertTrue(task.isCompleted());
    }

    @Test
    public void testMarkComplete_taskNotFound() {
        boolean marked = taskManager.markComplete("nonExistentTaskId");
        assertFalse(marked);
    }

    // You can add more tests here, and for the findTaskById method in TaskManager for task #3
}