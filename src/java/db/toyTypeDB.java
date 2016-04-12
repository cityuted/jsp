/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.ToyType;
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
public class toyTypeDB extends GeneralDB {

    public toyTypeDB() {
        connectDB();
    }
    
    public ArrayList<ToyType> listToyType() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOYTYPE");
            ArrayList<ToyType> tempToyTypeList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                ToyType tempToyType = new ToyType();
                tempToyType.setTypeID(rs.getInt("TYPEID"));
                tempToyType.setTypeName(rs.getString("TYPENAME"));
                tempToyType.setSexCategory(rs.getString("SEXCATEGORY"));
                tempToyType.setAgeCategory(rs.getString("AGECATEGORY"));
                
                tempToyTypeList.add(tempToyType);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempToyTypeList;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean createToyType(String toyType,String sexCategory,String ageCategory ) {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TOYTYPE(TYPENAME,SEXCATEGORY,AGECATEGORY) VALUES (?,?,?)");
            pstmt.setString(1, toyType);
            pstmt.setString(2, sexCategory);
            pstmt.setString(3, ageCategory);
            pstmt.executeUpdate();
            
            conn.commit();
            pstmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(toyTypeDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
    
    public boolean deleteToyType(int typeID)
    {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM TOYTYPE WHERE TYPEID = ?");
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
                Logger.getLogger(toyTypeDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
