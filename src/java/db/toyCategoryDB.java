/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.Category;
import bean.ToyCategory;
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
public class toyCategoryDB extends GeneralDB{
    public toyCategoryDB(){
        connectDB();
    }
    
    public ArrayList<ToyCategory> listToyCategoryByToyID(int ToyID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOYCATEGORY WHERE TOYID = ?");
            pstmt.setInt(1, ToyID);
            ArrayList<ToyCategory> tempToyCategoryList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                ToyCategory tempToyCategory = new ToyCategory();
                tempToyCategory.setCategoryID(rs.getInt("CATEGORYID"));
                tempToyCategory.setToyID(rs.getInt("TOYID"));

                tempToyCategoryList.add(tempToyCategory);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempToyCategoryList;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<ToyCategory> listToyCategory() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOYCATEGORY");
            ArrayList<ToyCategory> tempToyCategoryList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                ToyCategory tempToyCategory = new ToyCategory();
                tempToyCategory.setCategoryID(rs.getInt("CATEGORYID"));
                tempToyCategory.setToyID(rs.getInt("TOYID"));

                tempToyCategoryList.add(tempToyCategory);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempToyCategoryList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean createToyCategory(int categoryID,int toyID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TOYCATEGORY(CATEGORYID,TOYID) VALUES (?,?)");
            pstmt.setInt(1, categoryID);
            pstmt.setInt(2, toyID);
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

    public boolean deleteToyType(int categoryID,int toyID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM TOYCATEGORY WHERE CATEGORYID = ? AND TOYID = ?");
            pstmt.setInt(1, categoryID);
            pstmt.setInt(2, toyID);
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
    public boolean deleteToyType(int toyID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM TOYCATEGORY WHERE TOYID = ?");
          
            pstmt.setInt(1, toyID);
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
