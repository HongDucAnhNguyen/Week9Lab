/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

/**
 *
 * @author nguye
 */
import javax.persistence.EntityManager;
import models.Role;
import static models.User_.role;

public class RoleDB {

    public Role getRole(int roleNo) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Role role = em.find(Role.class, roleNo);
            return role;
        } finally {
            em.close();
        }

    }
}
