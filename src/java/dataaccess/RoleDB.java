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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Role;

public class RoleDB {

    public Role getRole(int roleNo) throws Exception {
        Role role = new Role();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connect = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM role WHERE role_id = ? ";
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, roleNo);
            rs = ps.executeQuery();
            if(rs.next()){
            String roleName = rs.getString(2);
            role = new Role(roleNo, roleName);
            }
        } finally {
             DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(connect);
        }

        return role;

    }
}
