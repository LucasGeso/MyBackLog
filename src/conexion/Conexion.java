package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
    private static final String URL = "jdbc:mysql://localhost:3306/mybacklog";
    private static final String USER = "root";
    private static final String PASSWORD = "Metallica92!";
    
    public static Connection getConexion() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL!");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }

        return con;
    }

}
