package vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Menu extends JFrame {
    public JButton btnPacientes = new JButton("Pacientes");
    public JButton btnCitas = new JButton("Citas");
    public JButton btnLogOut= new JButton("LogOut");

    public Menu() {
        initComponents();
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new FlowLayout());
        add(btnPacientes);
        add(btnCitas);
        add(btnLogOut);
    }
    
    public void disposeWindow() {
	    dispose(); 
	}
}