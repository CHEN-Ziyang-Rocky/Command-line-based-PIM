package info.pim.model;

import java.io.Serializable;

/**
 * Event Model
 */
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String startTime;

    private String alarm;

    private String description;

    public void copyData(Event source) {
        this.startTime = source.startTime;
        this.alarm = source.alarm;
        this.description = source.description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", startTime='" + startTime + '\'' +
                ", alarm='" + alarm + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
