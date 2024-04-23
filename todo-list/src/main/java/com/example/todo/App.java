package com.example.todo;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        boolean running = true;
        while (running) {
            System.out.println("1. Add a new task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. Update a task");
            System.out.println("4. Delete a task");
            System.out.println("5. View the list of tasks");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(title, description);
                    System.out.println("Task added.");
                    break;

                case 2:
                    System.out.print("Enter task title to mark as completed: ");
                    title = scanner.nextLine();
                    taskManager.markTaskAsCompleted(title);
                    System.out.println("Task marked as completed.");
                    break;

                case 3:
                    System.out.print("Enter task title to update: ");
                    String oldTitle = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    taskManager.updateTask(oldTitle, newTitle, newDescription);
                    System.out.println("Task updated.");
                    break;

                case 4:
                    System.out.print("Enter task title to delete: ");
                    title = scanner.nextLine();
                    taskManager.deleteTask(title);
                    System.out.println("Task deleted.");
                    break;

                case 5:
                    System.out.println("All tasks:");
                    for (Task task : taskManager.getAllTasks()) {
                        System.out.printf(" - %s: %s [%s]%n",
                                task.getTitle(), task.getDescription(),
                                task.isCompleted() ? "Completed" : "Not Completed");
                    }
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}
