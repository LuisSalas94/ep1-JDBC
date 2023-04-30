package cliente;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Scanner;

public class Cliente {
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Elija una opcion:\n 1.READ\n 2.CREATE\n 3.DELETE\n 4.UPDATE");
         int opcion = scanner.nextInt();
         ReadCliente readCliente = new ReadCliente();
         CreateCliente createCliente = new CreateCliente();
         DeleteCliente deleteCliente = new DeleteCliente();
         UpdateCliente updateCliente = new UpdateCliente();

         switch (opcion) {
             case 1: readCliente.read();break;
             case 2: createCliente.create();break;
             case 3: deleteCliente.delete();break;
             case 4: updateCliente.update();break;
             default:
                 System.out.println("Opcion incorrecta");
         }

    }
}
