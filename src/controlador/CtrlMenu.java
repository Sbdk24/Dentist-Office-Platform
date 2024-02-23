package controlador;

import vista.Menu;
import vista.frmPaciente;
import userAutentication.Main;
import modelo.PacienteModel;
import modelo.ConsultasPaciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlMenu implements ActionListener {
    private Menu menu;
    private frmPaciente pacienteVentana; 
    private String usertype;
    private CtrlPaciente ctrl;

    public CtrlMenu(Menu menu, String usertype) {
        this.menu = menu;
        this.usertype = usertype;
        this.menu.btnPacientes.addActionListener(this);
        this.menu.btnCitas.addActionListener(this);
        this.menu.btnLogOut.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu.btnPacientes) {
            PacienteModel mod = new PacienteModel();
            ConsultasPaciente modP = new ConsultasPaciente();
            pacienteVentana = new frmPaciente();
            applyUserTypeSettings(usertype);
            pacienteVentana.setVisible(true);
            ctrl = new CtrlPaciente(mod, modP, pacienteVentana);
            ctrl.iniciar();
            pacienteVentana.setVisible(true);
        } else if(e.getSource() == menu.btnCitas) {
            // Citas 
        } else if(e.getSource() == menu.btnLogOut) {
            if (pacienteVentana != null) {
                ctrl.closeFrmHistorial();
                pacienteVentana.dispose();
            }
            Main login = new Main();
            login.inicio();
            menu.disposeWindow(); // Close the menu window
        }
        
    }

    private void applyUserTypeSettings(String usertype) {
        switch (usertype) {
            case "dentista":
                pacienteVentana.btnGuardar.setVisible(false);
                pacienteVentana.btnModificar.setVisible(false);
                pacienteVentana.txtApellido.setEditable(false);
                pacienteVentana.txtCorreo.setEditable(false);
                pacienteVentana.txtEdad.setEditable(false);
                pacienteVentana.txtNumero.setEditable(false);
                pacienteVentana.txtSexo.setEditable(false);
                // To add "Actualizar Historial Médico" button or modify the window,
                // you might need to add a method in frmPaciente to handle this dynamically
                break;
            case "recepcion":
            	pacienteVentana.btnEliminar.setVisible(false);
            	pacienteVentana.btnHistorial.setVisible(false);
                break;
        }
    }
}
