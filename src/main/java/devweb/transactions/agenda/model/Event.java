package devweb.transactions.agenda.model;

import java.util.Date;

public class Event {

    private Long id;
    private String eventName;
    private Date eventDate;
    private String startHour;
    private String endHour;

    public Event(Long id, String eventName, Date eventDate, String startHour, String endHour) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startHour = startHour;
        this.endHour = endHour;
    }
    // getters and setters

    public Long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
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
