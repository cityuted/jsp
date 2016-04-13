/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.SecondHand;
import bean.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mesong
 */
public class secondHandDB extends GeneralDB {

    public secondHandDB() {
        connectDB();
    }

    public ArrayList<SecondHand> listSecondHand() {
        
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SECONDHAND");
            ArrayList<SecondHand> tempSecondHandList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                SecondHand tempSecondHand = new SecondHand();
                tempSecondHand.setID(rs.getInt("ID"));
                tempSecondHand.setCustID(rs.getInt("CUSTID"));
                tempSecondHand.setName(rs.getString("NAME"));
                tempSecondHand.setCashpoint(rs.getInt("CASHPOINT"));
                tempSecondHand.setApproval(rs.getString("APPROVAL"));
                //tempSecondHand.setToyID(rs.getInt("TOYID"));

                tempSecondHandList.add(tempSecondHand);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempSecondHandList;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<SecondHand> listSecondHandByCustomer(int custID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SECONDHAND WHERE CUSTID = ?");
            pstmt.setInt(1,custID);
            ArrayList<SecondHand> tempSecondHandList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                SecondHand tempSecondHand = new SecondHand();
                tempSecondHand.setID(rs.getInt("ID"));
                tempSecondHand.setCustID(rs.getInt("CUSTID"));
                tempSecondHand.setName(rs.getString("NAME"));
                tempSecondHand.setCashpoint(rs.getInt("CASHPOINT"));
                tempSecondHand.setApproval(rs.getString("APPROVAL"));
                //tempSecondHand.setToyID(rs.getInt("TOYID"));

                tempSecondHandList.add(tempSecondHand);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempSecondHandList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<SecondHand> searchSecondHand(String name) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SECONDHAND WHERE NAME LIKE '%" + name + "%'");
            ArrayList<SecondHand> tempSecondHandList = new ArrayList();
            while (rs.next()) {

                SecondHand tempSecondHand = new SecondHand();
                tempSecondHand.setID(rs.getInt("ID"));
                tempSecondHand.setCustID(rs.getInt("CUSTID"));
                tempSecondHand.setName(rs.getString("NAME"));
                tempSecondHand.setCashpoint(rs.getInt("CASHPOINT"));
                tempSecondHand.setApproval(rs.getString("APPROVAL"));
                //tempSecondHand.setToyID(rs.getInt("TOYID"));

                tempSecondHandList.add(tempSecondHand);
            }
            //stmnt.executeQuery()
            stmt.close();
            conn.close();
            return tempSecondHandList;

        } catch (SQLException ex) {
            return null;
        }

    }
    
    public ArrayList<SecondHand> searchSecondHandByCustomer(String name,int custID) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SECONDHAND WHERE NAME LIKE '%" + name + "%' AND CUSTID = " + custID);
            ArrayList<SecondHand> tempSecondHandList = new ArrayList();
            while (rs.next()) {

                SecondHand tempSecondHand = new SecondHand();
                tempSecondHand.setID(rs.getInt("ID"));
                tempSecondHand.setCustID(rs.getInt("CUSTID"));
                tempSecondHand.setName(rs.getString("NAME"));
                tempSecondHand.setCashpoint(rs.getInt("CASHPOINT"));
                tempSecondHand.setApproval(rs.getString("APPROVAL"));
                //tempSecondHand.setToyID(rs.getInt("TOYID"));

                tempSecondHandList.add(tempSecondHand);
            }
            //stmnt.executeQuery()
            stmt.close();
            conn.close();
            return tempSecondHandList;

        } catch (SQLException ex) {
            return null;
        }

    }

    public String createSecondHand(int custID, String name, int cashpoint) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SECONDHAND(CUSTID,NAME,CASHPOINT) VALUES(?,?,?)");
            pstmt.setInt(1, custID);
            pstmt.setString(2, name);
            pstmt.setInt(3, cashpoint);

            pstmt.executeUpdate();
            // }
            //stmnt.executeQuery()
            conn.commit();
            pstmt.close();
            conn.close();

            return null;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(secondHandDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return ex.getMessage();
        }

    }

    public boolean approveSecondHand(int ID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE SECONDHAND SET APPROVAL = 'APPROVED' WHERE ID = ?");

            pstmt.setInt(1, ID);
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(secondHandDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public boolean rejectSecondHand(int ID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE SECONDHAND SET APPROVAL = 'REJECTED' WHERE ID = ?");

            pstmt.setInt(1, ID);
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(secondHandDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
    
    public boolean restoreSecondHand(int ID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE SECONDHAND SET APPROVAL = 'WAITING' WHERE ID = ?");

            pstmt.setInt(1, ID);
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(secondHandDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
  
     public SecondHand searchSecondHand(int ID) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SECONDHAND WHERE ID = ?");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();
          //  ArrayList<SecondHand> tempSecondHandList = new ArrayList();
           SecondHand tempSecondHand = new SecondHand();
            while (rs.next()) {

               
                tempSecondHand.setID(rs.getInt("ID"));
                tempSecondHand.setCustID(rs.getInt("CUSTID"));
                tempSecondHand.setName(rs.getString("NAME"));
                tempSecondHand.setCashpoint(rs.getInt("CASHPOINT"));
                tempSecondHand.setApproval(rs.getString("APPROVAL"));
                //tempSecondHand.setToyID(rs.getInt("TOYID"));

               // tempSecondHandList.add(tempSecondHand);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempSecondHand;

        } catch (SQLException ex) {
            return null;
        }

    }
     
     public ArrayList<SecondHand> listApprovedSecondHand() {
        
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SECONDHAND WHERE APPROVAL ='APPROVED'");
            ArrayList<SecondHand> tempSecondHandList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                SecondHand tempSecondHand = new SecondHand();
                tempSecondHand.setID(rs.getInt("ID"));
                tempSecondHand.setCustID(rs.getInt("CUSTID"));
                tempSecondHand.setName(rs.getString("NAME"));
                tempSecondHand.setCashpoint(rs.getInt("CASHPOINT"));
                tempSecondHand.setApproval(rs.getString("APPROVAL"));
                //tempSecondHand.setToyID(rs.getInt("TOYID"));

                tempSecondHandList.add(tempSecondHand);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempSecondHandList;
        } catch (SQLException ex) {
            return null;
        }
    }
}
