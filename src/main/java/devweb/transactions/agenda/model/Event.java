package devweb.transactions.agenda.model;

import java.util.Date;

public class EventModel {

    private Long id;
    private String eventName;
    private Date eventDate;
    private String startHour;
    private String endHour;

    public EventModel(Long id, String eventName, Date eventDate, String startHour, String endHour) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    // getters and setters

}
