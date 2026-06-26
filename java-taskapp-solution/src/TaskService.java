public class TaskService {
    private final Task[] tasks = new Task[10];
    private int taskCount = 0;
    private int nextId = 1;

    public Task createTask(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Titel må ikke være tom");
        }
        if (taskCount >= tasks.length) {
            throw new IllegalStateException("Der er ikke plads til flere tasks");
        }

        Task task = new Task(nextId, title);
        tasks[taskCount] = task;
        taskCount++;
        nextId++;
        return task;
    }

    public Task[] getAllTasks() {
        Task[] result = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            result[i] = tasks[i];
        }
        return result;
    }

    public Task markTaskAsCompleted(int id) {
        Task task = findTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("Task med id " + id + " blev ikke fundet");
        }
        task.markAsCompleted();
        return task;
    }

    public int countOpenTasks() {
        int openTasks = 0;
        for (int i = 0; i < taskCount; i++) {
            if (!tasks[i].isCompleted()) {
                openTasks++;
            }
        }
        return openTasks;
    }

    private Task findTaskById(int id) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getId() == id) {
                return tasks[i];
            }
        }
        return null;
    }
}
