package devweb.transactions.agenda.dao;

import devweb.transactions.agenda.model.Event;
import devweb.transactions.agenda.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EventDAO {
    public void insert(Event event) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement insertEvent = connection.prepareStatement("insert into events (id, name, date, startHour, endHour) values(?,?,?,?,?)");
        insertEvent.setString(1, event.getId());
        insertEvent.setString(2, event.getEventName());
        insertEvent.setDate(3, java.sql.Date.valueOf(event.getEventDate()));
        insertEvent.setString(4, event.getStartHour());
        insertEvent.setString(5, event.getEndHour());

        insertEvent.executeUpdate();
    }

    public List<Event> getAll() throws SQLException {
        return null;
    }

    public void delete(Event event) throws SQLException {

    }
}
