package posjava;

import java.sql.*;

public class EmpleadoDAO {

    public static Empleado login(String user, String pass) {

    	String sql =
    	        "SELECT e.id_empleado, e.usuario, e.nombre, " +
    	        "e.id_rol, r.nombre AS rol " +
    	        "FROM empleado e " +
    	        "JOIN rol r ON e.id_rol = r.id_rol " +
    	        "WHERE e.usuario = ? AND e.passw = ? AND e.activo = 'S'";

    	    try (Connection con = ConexionBD.Conexion();
    	         PreparedStatement ps = con.prepareStatement(sql)) {

    	        ps.setString(1, user);
    	        ps.setString(2, pass);

    	        ResultSet rs = ps.executeQuery();

    	        if (rs.next()) {
    	            Empleado e = new Empleado();
    	            e.setIdEmpleado(rs.getInt("id_empleado"));
    	            e.setUsuario(rs.getString("usuario"));
    	            e.setNombre(rs.getString("nombre"));
    	            e.setIdRol(rs.getInt("id_rol"));
    	            e.setNombreRol(rs.getString("rol"));
    	            return e;
    	        }

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	    return null;
    }
}
