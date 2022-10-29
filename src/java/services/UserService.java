/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;
import models.User;
/**
 *
 * @author nguye
 */
public class UserService {
    
    public List<User> getAll() throws Exception{
        UserDB userDB = new UserDB();
        List<User> user = userDB.getAll();
        return user;  
    }
}
