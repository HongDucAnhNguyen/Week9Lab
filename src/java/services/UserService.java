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

    public void insert(String email, String firstname, String lastname, String password, String role) throws Exception {
        int roleID = 0;
        if (role.equals("system admin")) {
            roleID = 1;

        } else if (role.equals("regular user")) {
            roleID = 2;

        } else {
        }
        User user = new User(email, firstname, lastname, password, new Role(roleID, role));
        UserDB userDB = new UserDB();
        userDB.insertUser(user);
    }
}
