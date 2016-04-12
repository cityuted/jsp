/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.User;
import bean.UserType;
import static db.GeneralDB.conn_url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mesong
 */
public class userTypeDB extends GeneralDB {

    public userTypeDB() {
        connectDB();
    }
    
    public ArrayList<UserType> listUserType() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERTYPE");
            ArrayList<UserType> tempUserTypeList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                UserType tempUserType = new UserType();
                tempUserType.setID(rs.getInt("ID"));
                tempUserType.setType(rs.getString("TYPE"));
                
                tempUserTypeList.add(tempUserType);
            }
            //stmnt.executeQuery()
            return tempUserTypeList;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean createUserType(String userType) {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USERTYPE(TYPE) VALUES (?)");
            pstmt.setString(1, userType);
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userTypeDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
    
    public boolean deleteUserType(int typeID)
    {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM USERTYPE WHERE ID = ?");
            pstmt.setInt(1, typeID);
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userTypeDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
