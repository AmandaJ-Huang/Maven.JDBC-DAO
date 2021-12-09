package daos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/MyFaveMovies";
    public static final String USER = "rick";
    public static final String PASS = "rick123";

    /**
     * Get connection to database
     * @return Connection object
    */
    public static Connection getConnection() {
        try {
//            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database.");
        }
    }

    /**
     * Test Connection
     */

//    public static void main(String[] args) {
//        Connection connection = ConnectionFactory.getConnection();
//    }

}
