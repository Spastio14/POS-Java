package posjava;

import java.sql.*;

public class EmpleadoDAO {

    public static Empleado login(String user, String pass) {

        String sql =
            "SELECT id_empleado, usuario, nombre " +
            "FROM empleado " +
            "WHERE usuario = ? AND passw = ? AND activo = 'S'";

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
                return e;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
