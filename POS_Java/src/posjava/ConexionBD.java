package posjava;

import java.sql.*;

public class ConexionBD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/posdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "Admin123!";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}

