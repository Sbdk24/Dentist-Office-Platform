package userAutentication;

import vista.Menu;
import controlador.CtrlMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlUser {
    private UserModel userModel;
    private UserView userView;

    public CtrlUser(UserModel userModel, UserView userView) {
        this.userModel = userModel;
        this.userView = userView;
        userView.setAuthenticationListener(new AuthenticationListener());
    }

    private class AuthenticationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuarioIngresado = userView.getUsername();
            String contrasenaIngresada = userView.getPassword();
            User esAutenticado = userModel.authenticate(usuarioIngresado, contrasenaIngresada);
            
            if (esAutenticado != null) {
            	//Revisar si aqui cambia algo o si mando el tipo de usuario hasta la siguiente parte.
            	String usertype = esAutenticado.getUsertype();
            	Menu vista = new Menu(); 
                CtrlMenu controlador = new CtrlMenu(vista, usertype);
                vista.setVisible(true);
                userView.closeWindow(); 
            } else {
                userView.displayAuthenticationStatus(false);
            }
        }
    }
}
