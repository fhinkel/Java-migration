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
        assertEquals("Buy groceries", task.description());
        assertEquals(dueDate, task.dueDate());
        assertFalse(task.completed());
    }

    // You can add more tests here
     @Test
    public void testGetAllTasks() {
        Date dueDate1 = new Date();
        taskManager.addTask("Task 1", dueDate1);
        Date dueDate2 = new Date();
        taskManager.addTask("Task 2", dueDate2);
        Date dueDate3 = new Date();
        taskManager.addTask("Task 3", dueDate3);

        List<Task> allTasks = taskManager.getAllTasks();
        assertEquals(3, allTasks.size());
    }

    @Test
    public void testMarkComplete() {
        Date dueDate = new Date();
        String taskId = taskManager.addTask("Test Task", dueDate);
        Task task = taskManager.findTaskById(taskId);
        assertNotNull(task);

        assertTrue(taskManager.markComplete(taskId));
        assertFalse(task.completed());

        //Added check to see that the task is still retrievable.  A better test might be to verify
        //that getAllTasks correctly reflects the completed status.
        Task completedTask = taskManager.findTaskById(taskId);
        assertTrue(completedTask.completed());
    }
}