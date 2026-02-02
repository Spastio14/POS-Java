package posjava;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    public Principal() {

        setTitle("POS - Ventana Principal");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // =========================
        // MENSAJE SUPERIOR
        // =========================
        JLabel lblUsuario = new JLabel(
            "Usuario: " + Sesion.empleadoActual.getNombre()
        );
        lblUsuario.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(lblUsuario, BorderLayout.NORTH);

        // =========================
        // BOTÓN CERRAR SESIÓN
        // =========================
        JButton btnCerrarSesion = new JButton("Cerrar sesión");

        btnCerrarSesion.addActionListener(e -> cerrarSesion());

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnCerrarSesion);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void cerrarSesion() {

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea cerrar sesión?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {

            // limpiar sesión
            Sesion.cerrarSesion();

            // volver a login
            LoginForm login = new LoginForm();
            login.setVisible(true);

            // cerrar principal
            this.dispose();
        }
    }
}
