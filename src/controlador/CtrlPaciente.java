package controlador;

import modelo.PacienteModel;
import modelo.ConsultasPaciente;
import vista.frmPaciente;
import vista.frmHistorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlPaciente implements ActionListener {

    private PacienteModel mod;
    private ConsultasPaciente modP;
    private frmPaciente frm;
    private frmHistorial frmH;
    
    public CtrlPaciente(PacienteModel mod, ConsultasPaciente modP, frmPaciente frm)
    {
        this.mod = mod;
        this.modP = modP;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnHistorial.addActionListener(this); 
    }
    
    
    public void iniciar() 
    {
        frm.setTitle("Paciente");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }
    
    private void initializeFrmHistorial() {
        frmH = new frmHistorial();
        frmH.setVisible(true);
        // Assuming mod is already filled with data at this point:
        frmH.txtEnfermedades.setText(mod.getEnfermedades());
        frmH.txtMedicamentos.setText(mod.getMedicamentos());
        frmH.txtAlergias.setText(mod.getAlergias());
        frmH.txtIntervenciones.setText(mod.getIntervenciones());
    
        // Add action listeners for frmH components
        frmH.btnModificarH.addActionListener(this);
        frmH.btnGuardarH.addActionListener(this);
        frmH.btnCerrarVentanaH.addActionListener(this);
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frm.btnGuardar )
        {
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellido(frm.txtApellido.getText());
            mod.setEdad(Integer.parseInt(frm.txtEdad.getText()));
            mod.setSexo(frm.txtSexo.getText());
            mod.setNumero_telefonico(Integer.parseInt(frm.txtNumero.getText()));
            mod.setCorreo_electronico(frm.txtCorreo.getText());
            
            if(modP.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "Paciente Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar Paciente");   
                limpiar();
            }
        }
        if(e.getSource() == frm.btnModificar )
        {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellido(frm.txtApellido.getText());
            mod.setEdad(Integer.parseInt(frm.txtEdad.getText()));
            mod.setSexo(frm.txtSexo.getText());
            mod.setNumero_telefonico(Integer.parseInt(frm.txtNumero.getText()));
            mod.setCorreo_electronico(frm.txtCorreo.getText());
            
            if(modP.modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Paciente Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar Paciente");   
                limpiar();
            }
        }
        if(e.getSource() == frm.btnEliminar )
        {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if(modP.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Paciente eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar Paciente");   
                limpiar();
            }
        }
        if(e.getSource() == frm.btnBuscar )
        {
            mod.setNombre(frm.txtNombre.getText());
            
            if(modP.buscar(mod))
            {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtNombre.setText(mod.getNombre());
                frm.txtApellido.setText(mod.getApellido());
                frm.txtEdad.setText(String.valueOf(mod.getEdad()));
                frm.txtSexo.setText(mod.getSexo());
                frm.txtNumero.setText(String.valueOf(mod.getNumero_telefonico()));
                frm.txtCorreo.setText(mod.getCorreo_electronico());
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");   
                limpiar();
            }
        }
        if(e.getSource() == frm.btnLimpiar )
        { 
            limpiar();
        }
        if (e.getSource() == frm.btnHistorial) {
            initializeFrmHistorial();
            boolean exists = modP.checkHistorialExists(mod.getId());
            if (exists) {
                // Load existing data into mod
                modP.loadHistorialData(mod);
                // Now use mod to populate frmH fields
                frmH.txtEnfermedades.setText(mod.getEnfermedades());
                frmH.txtMedicamentos.setText(mod.getMedicamentos());
                frmH.txtAlergias.setText(mod.getAlergias());
                frmH.txtIntervenciones.setText(mod.getIntervenciones());
            } else {
                limpiarH();
            }
            frmH.setVisible(true);
        }
        
        if(e.getSource() == frmH.btnModificarH)
        {
            mod.setEnfermedades(frmH.txtEnfermedades.getText());
            mod.setMedicamentos(frmH.txtMedicamentos.getText());
            mod.setAlergias(frmH.txtAlergias.getText());
            mod.setIntervenciones(frmH.txtIntervenciones.getText());
            
            if(modP.modificarH(mod))
            {
                JOptionPane.showMessageDialog(null, "Historial Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar Historial");
            }
        
        }
        if(e.getSource() == frmH.btnGuardarH)
        {
            mod.setEnfermedades(frmH.txtEnfermedades.getText());
            mod.setMedicamentos(frmH.txtMedicamentos.getText());
            mod.setAlergias(frmH.txtAlergias.getText());
            mod.setIntervenciones(frmH.txtIntervenciones.getText());
            
            if(modP.registrarH(mod))
            {
                JOptionPane.showMessageDialog(null, "Historial Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar Historial");   
            }
        }
        if(e.getSource() == frmH.btnCerrarVentanaH)
        {
            frmH.dispose();
        }
    }
    
    public void limpiar()
    {
        frm.txtNombre.setText(null);
        frm.txtApellido.setText(null);
        frm.txtEdad.setText(null);
        frm.txtSexo.setText(null);
        frm.txtNumero.setText(null);       
        frm.txtCorreo.setText(null);
        frmH.txtAlergias.setText(null);
        frmH.txtIntervenciones.setText(null);
        frmH.txtEnfermedades.setText(null);       
        frmH.txtMedicamentos.setText(null);
    }
    public void limpiarH()
    {
        frmH.txtAlergias.setText(null);
        frmH.txtIntervenciones.setText(null);
        frmH.txtEnfermedades.setText(null);       
        frmH.txtMedicamentos.setText(null);
    }
    public void closeFrmHistorial() {
        if (frmH != null) {
            frmH.dispose();
        }
    }
    

}