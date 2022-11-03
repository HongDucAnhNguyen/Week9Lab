/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
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
    
    public void insert(String email, String firstname, String lastname, String password, String roleName) throws Exception {
        int roleID = 0;
        if (roleName.equals("system admin")) {
            roleID = 1;
        } else if (roleName.equals("regular user")) {
            roleID = 2;
        }
        
        User user = new User(email, firstname, lastname, password);
        RoleDB roleDB = new RoleDB();
        UserDB userDB = new UserDB();
        Role role = roleDB.getRole(roleID);
        user.setRole(role);
        userDB.insertUser(user);
    }
    
    public void update(String email, String firstname, String lastname, String password, String roleName) throws Exception {
         int roleID = 0;
        if (roleName.equals("system admin")) {
            roleID = 1;
        } else if (roleName.equals("regular user")) {
            roleID = 2;
        }
        UserDB userDB = new UserDB();
        RoleDB roleDB = new RoleDB();
        User user = userDB.get(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPassword(password);
        Role role = roleDB.getRole(roleID);
        user.setRole(role);
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}
