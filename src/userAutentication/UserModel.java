package userAutentication;

import java.util.ArrayList;

public class UserModel {
    private ArrayList<User> users;

    public UserModel(ArrayList<User> users) {
        this.users = users;
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; 
            }
        }
        return null; 
    }
}