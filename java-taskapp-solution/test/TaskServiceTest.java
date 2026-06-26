public class TaskServiceTest {
    public static void main(String[] args) {
        shouldCreateTask();
        shouldRejectEmptyTitle();
        shouldMarkTaskAsCompleted();
        shouldCountOpenTasks();
        shouldRejectUnknownId();
        System.out.println("Alle Java-tests bestod");
    }

    private static void shouldCreateTask() {
        TaskService service = new TaskService();
        Task task = service.createTask("Lær GitHub Copilot");

        assertEquals(1, task.getId(), "Første task skal have id 1");
        assertEquals("Lær GitHub Copilot", task.getTitle(), "Titel skal gemmes");
        assertFalse(task.isCompleted(), "Ny task skal ikke være færdig");
    }

    private static void shouldRejectEmptyTitle() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.createTask("   "), "Tom titel skal afvises");
    }

    private static void shouldMarkTaskAsCompleted() {
        TaskService service = new TaskService();
        Task task = service.createTask("Lav pull request");

        service.markTaskAsCompleted(task.getId());

        assertTrue(task.isCompleted(), "Task skal være markeret som færdig");
    }

    private static void shouldCountOpenTasks() {
        TaskService service = new TaskService();
        Task first = service.createTask("Åben task");
        Task second = service.createTask("Færdig task");
        service.markTaskAsCompleted(second.getId());

        assertEquals(1, service.countOpenTasks(), "Der skal være én åben task");
        assertFalse(first.isCompleted(), "Første task skal stadig være åben");
    }

    private static void shouldRejectUnknownId() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.markTaskAsCompleted(999), "Ukendt id skal afvises");
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ". Forventet: " + expected + ", faktisk: " + actual);
        }
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertThrows(Class<? extends Exception> expectedException, Runnable action, String message) {
        try {
            action.run();
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                return;
            }
            throw new AssertionError(message + ". Forkert exception: " + e.getClass().getSimpleName());
        }
        throw new AssertionError(message + ". Der blev ikke kastet en exception.");
    }
}
