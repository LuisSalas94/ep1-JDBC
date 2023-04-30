package cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadCliente {
    public static void read() throws SQLException, ClassNotFoundException {

        Connection connection = DataBaseConnection.getConnection();

        String query = "select * from cliente where ciudad = 'Lima'";
        String query2 = "select * from cliente";

        Statement statement = connection.createStatement();
        Statement statement2 = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        ResultSet resultSet2 = statement2.executeQuery(query2);

        while (resultSet.next()) {
            System.out.println("Clientes de Lima");
            String toPrint = "Nombre y Apellidos:" + resultSet.getString("nombres") + " " + resultSet.getString("apellido_paterno") + " " +
                    resultSet.getString("apellido_materno") + "\nCiudad: " + resultSet.getString("ciudad");
            System.out.println(toPrint);
            System.out.println("********************************");
        }

        while (resultSet2.next()) {
            System.out.println("Todos los clientes");
            String toPrint = "Nombre y Apellidos:" + resultSet2.getString("nombres") + " " + resultSet2.getString("apellido_paterno") +
                    resultSet2.getString("apellido_materno") + "\nCiudad: " + resultSet2.getString("ciudad");
            System.out.println(toPrint);
            System.out.println("********************************");
        }
    }
}
