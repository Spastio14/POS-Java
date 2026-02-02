package posjava;

public class Sesion {

    // Empleado actualmente logueado
    public static Empleado empleadoActual;

    // Evita que se instancie la clase
    private Sesion() {
    }

    // Verificar si hay sesión activa
    public static boolean haySesion() {
        return empleadoActual != null;
    }

    // Cerrar sesión
    public static void cerrarSesion() {
        empleadoActual = null;
    }
}
