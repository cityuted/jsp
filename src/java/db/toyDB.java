/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.Toy;
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
public class toyDB extends GeneralDB {

    public toyDB() {
        connectDB();
    }

    public ArrayList<Toy> listToy() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOY");
            ArrayList<Toy> tempToyList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
             
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));

                tempToyList.add(tempToy);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempToyList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Toy> listSecondHandToy() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOY WHERE SECONDHANDID IS NOT NULL");
            ArrayList<Toy> tempToyList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
               // tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));

                tempToyList.add(tempToy);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempToyList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Toy> listToyByCategory(int typeID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOY WHERE TYPEID = ?");
            pstmt.setInt(1, typeID);

            ResultSet rs = pstmt.executeQuery();
            ArrayList<Toy> tempToyList = new ArrayList();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
              //  tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));

                tempToyList.add(tempToy);
            }
            pstmt.close();
            conn.close();
            return tempToyList;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Toy> listSecondHandToyByCategory(int typeID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOY WHERE SECONDHANDID IS NOT NULL AND TYPEID = ?");
            pstmt.setInt(1, typeID);

            ResultSet rs = pstmt.executeQuery();
            ArrayList<Toy> tempToyList = new ArrayList();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
               // tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));

                tempToyList.add(tempToy);
            }
            pstmt.close();
            conn.close();
            return tempToyList;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Toy> searchToy(String toyName) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TOY WHERE TOYNAME LIKE '%" + toyName + "%'");

            ArrayList<Toy> tempToyList = new ArrayList();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
              //  tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));
                tempToyList.add(tempToy);
            }
            stmt.close();
            conn.close();
            return tempToyList;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }

    }

    public Toy searchToyByID(String toyID) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TOY WHERE TOYID = " + toyID);

            ArrayList<Toy> tempToyList = new ArrayList();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
              //  tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));
                tempToyList.add(tempToy);
                return tempToy;
            }
            stmt.close();
            conn.close();
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public ArrayList<Toy> searchSecondHandToy(String toyName) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TOY WHERE SECONDHANDID IS NOT NULL AND TOYNAME LIKE '%" + toyName + "%'");

            ArrayList<Toy> tempToyList = new ArrayList();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
               // tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));
                tempToyList.add(tempToy);
            }
            stmt.close();
            conn.close();
            return tempToyList;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }

    }

    public ArrayList<Toy> searchToyByCategory(String toyName, int typeID) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TOY WHERE TOYNAME LIKE '%" + toyName + "%' AND TYPEID = '" + typeID + "'");

            ArrayList<Toy> tempToyList = new ArrayList();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
              //  tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));
                tempToyList.add(tempToy);
            }
            stmt.close();
            conn.close();
            return tempToyList;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }

    }

    public ArrayList<Toy> searchSecondHandToyByCategory(String toyName, int typeID) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TOY WHERE SECONDHANDID IS NOT NULL AND TOYNAME LIKE '%" + toyName + "%' AND TYPEID = '" + typeID + "'");

            ArrayList<Toy> tempToyList = new ArrayList();
            while (rs.next()) {

                Toy tempToy = new Toy();
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
              //  tempToy.setTypeID(rs.getInt("TYPEID"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));
                tempToyList.add(tempToy);
            }
            return tempToyList;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }

    }

    public boolean createToy(String toyName, String description, String toyIcon, int cashpoint, int qty, int discount, int typeID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TOY(TOYNAME,DESCRIPTION,TOYICON,CASHPOINT,QTY,DISCOUNT,TYPEID)"
                    + "VALUES(?,?,?,?,?,?,?)");
            pstmt.setString(1, toyName);
            pstmt.setString(2, description);
            pstmt.setString(3, toyIcon);
            pstmt.setInt(4, cashpoint);
            pstmt.setInt(5, qty);
            pstmt.setInt(6, discount);
            pstmt.setInt(7, typeID);

            pstmt.executeUpdate();
            // }
            //stmnt.executeQuery()
            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(toyDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public String createSecondHandToy(String toyName, String description, String toyIcon, int cashpoint, int qty, int discount, int typeID, int secondHandID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TOY(TOYNAME,DESCRIPTION,TOYICON,CASHPOINT,QTY,DISCOUNT,TYPEID,SECONDHANDID)"
                    + "VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, toyName);
            pstmt.setString(2, description);
            pstmt.setString(3, toyIcon);
            pstmt.setInt(4, cashpoint);
            pstmt.setInt(5, qty);
            pstmt.setInt(6, discount);
            pstmt.setInt(7, typeID);
            pstmt.setInt(8, secondHandID);
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
                Logger.getLogger(toyDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return ex.getMessage();
        }

    }

    public boolean updateToy(int toyID, String toyIcon, int cashpoint, int QTY, int discount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE TOY SET TOYICON=?,CASHPOINT=?,QTY=?,DISCOUNT=? WHERE TOYID = ?");

            if (toyIcon.equals("")) {
                toyIcon = "";
            }

            pstmt.setString(1, toyIcon);
            pstmt.setInt(2, cashpoint);
            pstmt.setInt(3, QTY);
            pstmt.setInt(4, discount);
            pstmt.setInt(5, toyID);
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(toyDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public boolean updateToyByCategory(int typeID, int discount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE TOY SET DISCOUNT = ? WHERE TYPEID = ?");

            pstmt.setInt(1, discount);
            pstmt.setInt(2, typeID);
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(toyDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public boolean deleteToy(int toyID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM TOY WHERE TOYID = ?");

            pstmt.setInt(1, toyID);
            pstmt.executeUpdate();
            // }
            //stmnt.executeQuery()
            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(toyDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public boolean createToy(String toyName, String description, String toyIcon, int cashpoint, int qty, int discount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TOY(TOYNAME,DESCRIPTION,TOYICON,CASHPOINT,QTY,DISCOUNT)"
                    + "VALUES(?,?,?,?,?,?)");
            pstmt.setString(1, toyName);
            pstmt.setString(2, description);
            pstmt.setString(3, toyIcon);
            pstmt.setInt(4, cashpoint);
            pstmt.setInt(5, qty);
            pstmt.setInt(6, discount);

            pstmt.executeUpdate();
            // }
            //stmnt.executeQuery()
            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {

            }
            return false;
        }

    }

    public boolean updateToySecondHand(int toyID, int secondHandID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE TOY SET SECONDHANDID = ? WHERE TOYID = ?");
            if (secondHandID == -1) {
                pstmt.setNull(1, java.sql.Types.INTEGER);
            } else {
                pstmt.setInt(1, secondHandID);
            }

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

            }
            return false;
        }

    }

    public boolean updateToy(int toyID, String toyName, String description, String toyIcon, int cashpoint, int QTY, int discount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE TOY SET TOYNAME = ?,DESCRIPTION = ?,TOYICON=?,CASHPOINT=?,QTY=?,DISCOUNT=? WHERE TOYID = ?");

            if (toyIcon.equals("")) {
                toyIcon = "";
            }
            pstmt.setString(1, toyName);
            pstmt.setString(2, description);
            pstmt.setString(3, toyIcon);

            pstmt.setInt(4, cashpoint);
            pstmt.setInt(5, QTY);
            pstmt.setInt(6, discount);
            pstmt.setInt(7, toyID);
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {

            }
            return false;
        }

    }
    
     public Toy listToyByID(int toyID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TOY WHERE TOYID = ?");
            pstmt.setInt(1, toyID);
            ArrayList<Toy> tempToyList = new ArrayList();
            Toy tempToy = new Toy();
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {

                
                tempToy.setToyID(rs.getInt("TOYID"));
                tempToy.setToyName(rs.getString("TOYNAME"));
                tempToy.setDescription(rs.getString("DESCRIPTION"));
                tempToy.setToyIcon(rs.getString("TOYICON"));
                tempToy.setCashpoint(rs.getInt("CASHPOINT"));
                tempToy.setQTY(rs.getInt("QTY"));
                tempToy.setDiscount(rs.getInt("DISCOUNT"));
               //tempToy.setIcon(rs.getBlob("TOYICON"));
                tempToy.setSecondHandID(rs.getInt("SECONDHANDID"));

                tempToyList.add(tempToy);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempToy;
        } catch (SQLException ex) {
            return null;
        }
    }
     
      public int getNextAvailableID()
    {
        return getAutoIncrement("toy");
    }
}
