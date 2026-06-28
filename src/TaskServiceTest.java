public class TaskServiceTest {
    public static void main(String[] args) {
        shouldCreateTask();
        shouldRejectEmptyTitle();
        shouldReturnAllTasks();
        System.out.println("Alle tests bestod");
    }

    private static void shouldCreateTask() {
        TaskService taskService = new TaskService();
        Task task = taskService.createTask("Køb mælk");

        assertEquals(1, task.getId(), "Første task skal have id 1");
        assertEquals("Køb mælk", task.getTitle(), "Titlen skal gemmes");
        assertFalse(task.isCompleted(), "Ny task skal være ikke færdig");
    }

    private static void shouldRejectEmptyTitle() {
        TaskService taskService = new TaskService();

        try {
            taskService.createTask("   ");
            throw new AssertionError("Tom titel skulle være afvist");
        } catch (IllegalArgumentException expected) {
        }
    }

    private static void shouldReturnAllTasks() {
        TaskService taskService = new TaskService();
        taskService.createTask("Task 1");
        taskService.createTask("Task 2");

        Task[] tasks = taskService.getAllTasks();

        assertEquals(2, tasks.length, "Der skal være to tasks");
        assertEquals("Task 1", tasks[0].getTitle(), "Første task skal ligge først");
        assertEquals("Task 2", tasks[1].getTitle(), "Anden task skal ligge som nummer to");
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ". Forventet: " + expected + ", faktisk: " + actual);
        }
    }

    private static void assertFalse(boolean value, String message) {
        if (value) {
            throw new AssertionError(message);
        }
    }
}
