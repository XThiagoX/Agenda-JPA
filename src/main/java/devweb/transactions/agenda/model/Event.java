package devweb.transactions.agenda.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Event {

    private String id = UUID.randomUUID().toString();
    private String eventName;
    private LocalDate eventDate;
    private String startHour;
    private String endHour;

    public Event(String id, String eventName, LocalDate eventDate, String startHour, String endHour) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startHour = startHour;
        this.endHour = endHour;
    }
    // getters and setters

    public String getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

}
