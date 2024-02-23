package userAutentication;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    	Main iniciar = new Main();
    	iniciar.inicio();
    }
    public void inicio() {
    	ArrayList<User> users = new ArrayList<>();
        users.add(new User("usuario123", "contrasenaSecreta", "dentista"));
        users.add(new User("otrousuario", "otracontrasena", "recepcion"));

        UserModel userModel = new UserModel(users);
        UserView userView = new UserView();
        CtrlUser userController = new CtrlUser(userModel, userView);
    }
}
