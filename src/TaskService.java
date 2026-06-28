public class TaskService {
    private final Task[] tasks;
    private int taskCount;
    private int nextId;

    public TaskService() {
        this.tasks = new Task[10];
        this.taskCount = 0;
        this.nextId = 1;
    }

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
        Task[] allTasks = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            allTasks[i] = tasks[i];
        }
        return allTasks;
    }

    public Task markTaskAsCompleted(int id) {
        Task task = findTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("Task med id " + id + " blev ikke fundet");
        }

        task.markAsCompleted();
        return task;
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
