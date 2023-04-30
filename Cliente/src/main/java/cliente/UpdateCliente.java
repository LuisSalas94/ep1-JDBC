package cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCliente {
    public static void update() throws ClassNotFoundException, SQLException {

        Connection connection = DataBaseConnection.getConnection();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nuevo correo: ");
        String email = scanner.nextLine();

        System.out.println("Ingrese ID del usuario: ");
        int id = scanner.nextInt();

        String query = "UPDATE cliente SET correo = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setInt(2, id);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed!");
        }
    }
}
