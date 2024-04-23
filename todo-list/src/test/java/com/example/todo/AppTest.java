package com.example.todo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Test Task", "This is a test task.");
        assertEquals("Test Task", task.getTitle());
        assertEquals("This is a test task.", task.getDescription());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testTaskManager() {
        TaskManager manager = new TaskManager();
        manager.addTask("Task 1", "First task");
        manager.addTask("Task 2", "Second task");

        // Ensure tasks were added successfully
        assertEquals(2, manager.getAllTasks().size());

        // Mark "Task 1" as completed and check if it's really completed
        manager.markTaskAsCompleted("Task 1");
        Task task1 = manager.getTaskByTitle("Task 1");
        assertNotNull(task1);
        assertTrue(task1.isCompleted());

        // Update "Task 2" and check if it updates correctly
        manager.updateTask("Task 2", "Task 2 Updated", "Updated description");
        Task task2 = manager.getTaskByTitle("Task 2 Updated");
        assertNotNull(task2);
        assertEquals("Task 2 Updated", task2.getTitle());
        assertEquals("Updated description", task2.getDescription());

        // Delete "Task 2" and ensure it's gone
        manager.deleteTask("Task 2 Updated");
        assertNull(manager.getTaskByTitle("Task 2 Updated"));
    }
}
