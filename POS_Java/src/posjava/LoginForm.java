package posjava;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
    private JPasswordField txtPassword;

    public LoginForm() {

        setTitle("Login POS");
        setSize(350, 230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(40, 40, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 40, 170, 25);
        add(txtUsuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(40, 80, 80, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 80, 170, 25);
        add(txtPassword);

        JButton btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(120, 130, 100, 30);
        add(btnLogin);

        btnLogin.addActionListener(e -> login());
    }

    private void login() {

        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());

        Empleado emp = EmpleadoDAO.login(user, pass);

        if (emp != null) {
            JOptionPane.showMessageDialog(this,
                    "Bienvenido " + emp.getNombre());
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos");
        }
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
