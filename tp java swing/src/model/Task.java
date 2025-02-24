package model;

public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false; // Par d�faut, une t�che est non termin�e
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }


    public String toString() {
        return (completed ? "[X] " : "[ ] ") + description;
    }
}
