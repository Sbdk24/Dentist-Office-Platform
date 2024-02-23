package userAutentication;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;


public class UserView {
    private JFrame frame;
    private JButton autenticar;
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;

    public UserView() {
        frame = new JFrame("Sistema de Autenticación");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        campoUsuario = new JTextField(20);
        campoUsuario.setBounds(100, 20, 165, 25);
        panel.add(campoUsuario);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        campoContrasena = new JPasswordField(20);
        campoContrasena.setBounds(100, 50, 165, 25);
        panel.add(campoContrasena);

        autenticar = new JButton("Autenticar");
        autenticar.setBounds(10, 80, 150, 25);
        panel.add(autenticar);
    }

    public String getUsername() {
        return campoUsuario.getText();
    }

    public String getPassword() {
        return new String(campoContrasena.getPassword());
    }

    public void setAuthenticationListener(ActionListener listener) {
    	autenticar.addActionListener(listener);
    }

    public void displayAuthenticationStatus(boolean isAuthenticated) {
    	JOptionPane.showMessageDialog(frame, isAuthenticated ? "Autenticación exitosa" : "Autenticación fallida. Usuario o contraseña incorrectos.",
                "Estado de Autenticación", isAuthenticated ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

	public void closeWindow() {
	    frame.dispose(); 
	}

}

