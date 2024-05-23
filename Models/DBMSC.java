package Models;
import java.sql.*;

public class DBMSC {
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String user = "system";
    private static String password = "inesINES";
    
    private static Connection connection;

    public static void createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) { 
            connection.close();
        }
    }

    public static Connection getConnection() {
        return connection;
    }



}
