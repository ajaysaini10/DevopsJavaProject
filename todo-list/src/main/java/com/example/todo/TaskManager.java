package com.example.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, String description) {
        tasks.add(new Task(title, description));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    public void markTaskAsCompleted(String title) {
        Task task = getTaskByTitle(title);
        if (task != null) {
            task.setCompleted(true);
        }
    }

    public void updateTask(String oldTitle, String newTitle, String newDescription) {
        Task task = getTaskByTitle(oldTitle);
        if (task != null) {
            task.setTitle(newTitle);
            task.setDescription(newDescription);
        }
    }

    public void deleteTask(String title) {
        Task task = getTaskByTitle(title);
        if (task != null) {
            tasks.remove(task);
        }
    }
}
