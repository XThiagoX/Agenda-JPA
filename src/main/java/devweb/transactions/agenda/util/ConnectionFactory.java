package devweb.transactions.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String url = "jdbc:mysql://localhost:3306/AgendaDatabase?useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "admin";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found", e);
        }catch (SQLException e){
            throw new RuntimeException("Connection failed", e);
        }


    }
}
