package devweb.transactions.agenda.dao;

import devweb.transactions.agenda.model.Event;
import devweb.transactions.agenda.util.ConnectionFactory;

import java.sql.*;
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
        connection.close();
    }

    public List<Event> getAll() throws SQLException {
        return null;
    }

    public Event getById(String id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement selectEvent = connection.prepareStatement("select * from events where id = ?");
        selectEvent.setString(1, id);
        ResultSet resultSet = selectEvent.executeQuery();

        if (resultSet.next()) {
            Event event = new Event(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("date").toLocalDate(),
                    resultSet.getString("startHour"),
                    resultSet.getString("endHour")
            );
            return event;
        }else {
            return null;
        }
    }

    public void delete(Event event) throws SQLException {
        PreparedStatement deleteEvent = ConnectionFactory.getConnection().prepareStatement("delete from events where id = ?");
        deleteEvent.setString(1, event.getId());
        deleteEvent.executeUpdate();
        deleteEvent.close();
    }
}
