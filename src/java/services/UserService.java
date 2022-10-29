/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author nguye
 */
public class UserService {

    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public String insert(String email, String firstname, String lastname, String password, String role) throws Exception {
        String insertMessage = "";
        int roleID = 0;
        if (role.equals("system admin")) {
            roleID = 1;

        } else if (role.equals("regular user")) {
            roleID = 2;

        } else {
            return "";
        }
        User user = new User(email, firstname, lastname, password, new Role(roleID, role));
        UserDB userDB = new UserDB();
        insertMessage = userDB.insertUser(user);
        return insertMessage;
    }

    public void update(String email, String firstname, String lastname, String password, String role) throws Exception {
        int roleID = 0;
        if (role.equals("system admin")) {
            roleID = 1;

        } else if (role.equals("regular user")) {
            roleID = 2;

        } else {
            return;
        }
        User user = new User(email, firstname, lastname, password, new Role(roleID, role));
        UserDB userDB = new UserDB();
        userDB.update(user);
    }

    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
