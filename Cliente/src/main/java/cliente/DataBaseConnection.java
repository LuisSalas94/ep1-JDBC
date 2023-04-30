package cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseConnection {
    private static Connection connection;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/develop";
            connection = DriverManager.getConnection(url, "root", "root");
        }
        return connection;
    }
}
