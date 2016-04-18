/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.Category;
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
public class categoryDB extends GeneralDB {

    public categoryDB() {
        connectDB();
    }

    public ArrayList<Category> listToyCategory() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CATEGORY");
            ArrayList<Category> tempCategoryList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Category tempCategory = new Category();
                tempCategory.setCategoryID(rs.getInt("CATEGORYID"));
                tempCategory.setCategoryName(rs.getString("CATEGORYNAME"));

                tempCategoryList.add(tempCategory);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempCategoryList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Category searchCategory(int categoryID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CATEGORY WHERE CATEGORYID = ?");
            //ArrayList<Category> tempCategoryList = new ArrayList();
            pstmt.setInt(1, categoryID);
            ResultSet rs = pstmt.executeQuery();
            Category tempCategory = new Category();
            while (rs.next()) {

                tempCategory.setCategoryID(rs.getInt("CATEGORYID"));
                tempCategory.setCategoryName(rs.getString("CATEGORYNAME"));

                //tempCategoryList.add(tempCategory);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempCategory;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean createToyCategory(String categorName) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CATEGORY(CATEGORYNAME) VALUES (?)");
            pstmt.setString(1, categorName);

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

    public boolean deleteToyType(int categoryID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM CATEGORY WHERE CATEGORYID = ?");
            pstmt.setInt(1, categoryID);
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
    
     public boolean updateToyType(int categoryID,String categoryName) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE CATEGORY SET CATEGORYNAME = ? WHERE CATEGORYID = ?");
            pstmt.setString(1, categoryName);
            pstmt.setInt(2, categoryID);
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
