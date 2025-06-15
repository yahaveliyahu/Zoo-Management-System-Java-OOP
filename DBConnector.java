package yahav_eliyahu_arad_rotem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    // Returns a connection to the database
    public static Connection connect() {
        try {
            Class.forName("org.postgresql.Driver"); // Loading the PostgreSQL driver

            // Connection settings:
            String url = "jdbc:postgresql://localhost:5432/zoo_management"; // Database name
            String user = "postgres";       // Your pgAdmin username
            String password = "123456";

            // Returns the connection
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null; // If there is an error – returns null
        }
    }
}
