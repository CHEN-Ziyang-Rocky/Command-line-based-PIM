package info.pim.model;

import java.io.Serializable;

/**
 * Task Model
 */
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String deadline;

    private String description;

    public void copyData(Task source) {
        this.deadline = source.deadline;
        this.description = source.description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", deadline='" + deadline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
