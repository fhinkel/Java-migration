package com.example.taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager taskManager;
    private Date testDate;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        testDate = new Date();
    }

    @Test
    void addTask() {
        String taskId = taskManager.addTask("Test Task", testDate);
        assertNotNull(taskId);
        Task task = taskManager.findTaskById(taskId);
        assertNotNull(task);
        assertEquals("Test Task", task.getDescription());
        assertEquals(testDate, task.getDueDate());
        assertFalse(task.isCompleted());
    }

    @Test
    void getAllTasks() {
        taskManager.addTask("Task 1", testDate);
        taskManager.addTask("Task 2", testDate);
        List<Task> tasks = taskManager.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    void getAllTasks_empty() {
        List<Task> tasks = taskManager.getAllTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    void markComplete() {
        String taskId = taskManager.addTask("Test Task", testDate);
        boolean marked = taskManager.markComplete(taskId);
        assertTrue(marked);
        Task task = taskManager.findTaskById(taskId);
        assertTrue(task.isCompleted());
    }

    @Test
    void markComplete_taskNotFound() {
        boolean marked = taskManager.markComplete("nonexistent-id");
        assertFalse(marked);
    }

    @Test
    void findTaskById() {
        String taskId = taskManager.addTask("Test Task", testDate);
        Task task = taskManager.findTaskById(taskId);
        assertNotNull(task);
        assertEquals(taskId, task.getId());
        assertEquals("Test Task", task.getDescription());
        assertEquals(testDate, task.getDueDate());
        assertFalse(task.isCompleted());
    }

    @Test
    void findTaskById_notFound() {
        Task task = taskManager.findTaskById("nonexistent-id");
        assertNull(task);
    }

    @Test
    void testTaskConstructorAndGetters() {
        String id = "test-id";
        String description = "Test Description";
        Date dueDate = new Date();
        Task task = new Task(id, description, dueDate);

        assertEquals(id, task.getId());
        assertEquals(description, task.getDescription());
        assertEquals(dueDate, task.getDueDate());
        assertFalse(task.isCompleted());
    }
    
    @Test
    void testTaskSetters(){
        String id = "test-id";
        String description = "Test Description";
        Date dueDate = new Date();
        Task task = new Task(id, description, dueDate);
        
        String newId = "new-test-id";
        String newDescription = "new Test Description";
        Date newDueDate = new Date(dueDate.getTime() + 10000);
        boolean newCompleted = true;
        
        task.setId(newId);
        task.setDescription(newDescription);
        task.setDueDate(newDueDate);
        task.setCompleted(newCompleted);

        assertEquals(newId, task.getId());
        assertEquals(newDescription, task.getDescription());
        assertEquals(newDueDate, task.getDueDate());
        assertTrue(task.isCompleted());
    }

}
