package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/movies";
    public static final String USER = "root";
    public static final String PASS = "zipcode0";

    /**
     * Get connection to database
     * @return Connection object
    */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new RuntimeException();
    }

    /**
     * Test Connection
     */

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }

}
