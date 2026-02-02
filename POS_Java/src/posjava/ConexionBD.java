package posjava;

import java.io.File;
import java.sql.*;

import javax.swing.*;

public class ConexionBD {
	// Carpeta: C:\Users\TU_USUARIO\FarmaciaDB
    private static final String userHome = System.getProperty("user.home");
    private static final String carpetaBD = userHome + File.separator + "POSjavs";
    private static final String rutaBD = carpetaBD + File.separator + "POS_java.db";
    private static final String DB_URL = "jdbc:sqlite:" + rutaBD;

    // ==============================
    // CONEXIÓN
    // ==============================
    public static Connection Conexion() {
        try {
        	Class.forName("org.sqlite.JDBC");
        	//JOptionPane.showMessageDialog(null, DB_URL);
            File carpeta = new File(carpetaBD);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            return DriverManager.getConnection(DB_URL);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al conectar BD: " + e.getMessage()
            );
            return null;
        }
    }
    
    public static ResultSet obtenerEmpleados() {

        String sql = "SELECT * FROM empleado";

        try {
            Connection con = Conexion();
            Statement st = con.createStatement();
            return st.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando empleados: " + e.getMessage());
            return null;
        }
    }

    
    /*public static void main(String[] args) {
    	Connection conn = Conexion();
    	
    	/*ResultSet rs = ConexionBD.obtenerEmpleados();

    	try {
			while(rs.next()){
			    System.out.println(
			        rs.getInt("id_empleado") + " - " +
			        rs.getString("usuario") + " - " +
			        rs.getString("nombre") + " - " + 
			        rs.getString("fecha_registro")
			    );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
}

