import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskService taskService = new TaskService();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                createTask();
            } else if (choice.equals("2")) {
                showAllTasks();
            } else if (choice.equals("3")) {
                markTaskAsCompleted();
            } else if (choice.equals("0")) {
                running = false;
                System.out.println("Farvel");
            } else {
                System.out.println("Ugyldigt valg");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Opret task");
        System.out.println("2. Se alle tasks");
        System.out.println("3. Marker task som færdig");
        System.out.println("0. Afslut");
        System.out.print("Vælg: ");
    }

    private static void createTask() {
        System.out.print("Titel: ");
        String title = scanner.nextLine();

        try {
            Task task = taskService.createTask(title);
            System.out.println("Task oprettet: " + task);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    private static void showAllTasks() {
        Task[] tasks = taskService.getAllTasks();

        if (tasks.length == 0) {
            System.out.println("Der er ingen tasks endnu.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void markTaskAsCompleted() {
        System.out.print("Indtast id: ");
        String input = scanner.nextLine();

        try {
            int id = Integer.parseInt(input);
            Task task = taskService.markTaskAsCompleted(id);
            System.out.println("Markeret som færdig: " + task);
        } catch (NumberFormatException e) {
            System.out.println("Fejl: id skal være et tal");
        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }
}
