package cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCliente {
    public static void delete() throws ClassNotFoundException, SQLException {

        Connection connection = DataBaseConnection.getConnection();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un id");
        int id = scanner.nextInt();

        String query = "delete from cliente where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Delete successful!");
        } else {
            System.out.println("Delete failed!");
        }
    }
}
