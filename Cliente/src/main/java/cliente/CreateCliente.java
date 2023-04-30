package cliente;

import java.sql.*;
import java.util.Scanner;

public class CreateCliente {
    public static void create() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido paterno");
        String apellido1 = scanner.nextLine();

        System.out.println("Ingrese apellido materno");
        String apellido2 = scanner.nextLine();

        System.out.println("Ingrese fecha nacimiento (yyyy-MM-dd)");
        String fNacimiento = scanner.nextLine();

        System.out.println("Ingrese correo");
        String correo = scanner.nextLine();

        System.out.println("Ingrese ciudad");
        String ciudad = scanner.nextLine();

        Connection connection = DataBaseConnection.getConnection();

        String query = "INSERT INTO cliente (nombres, apellido_paterno, apellido_materno, fecha_nacimiento, correo, ciudad) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, apellido1);
        preparedStatement.setString(3, apellido2);
        preparedStatement.setString(4, fNacimiento);
        preparedStatement.setString(5, correo);
        preparedStatement.setString(6, ciudad);
        preparedStatement.execute();

        String selectQuery = "select * from cliente";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        int count = 1;
        while (resultSet.next()) {
            String toPrint = "El resultado de la fila " + count + " es " +
                    resultSet.getString("nombres") + " " +
                    resultSet.getString("apellido_paterno") + " " +
                    resultSet.getString("apellido_materno") + " " +
                    resultSet.getString("fecha_nacimiento") + " " +
                    resultSet.getString("correo") + " " +
                    resultSet.getString("ciudad");
            System.out.println(toPrint);
            count++;
        }
    }
}
