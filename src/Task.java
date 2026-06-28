public class Task {
    private final int id;
    private final String title;
    private boolean completed;

    public Task(int id, String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Titel må ikke være tom");
        }

        this.id = id;
        this.title = title.trim();
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    public String getStatusText() {
        return completed ? "færdig" : "ikke færdig";
    }

    @Override
    public String toString() {
        return id + ". " + title + " - " + getStatusText();
    }
}
