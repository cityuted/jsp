/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.Message;
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
public class messageDB extends GeneralDB {

    public messageDB() {
        connectDB();
    }

    public Boolean checkAddMessage(int transID,int toyID,int custID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("select * from transactionheader,transactionitem where transactionheader.TRANSACTIONID = transactionitem.TRANSACTIONID and transactionitem.TRANSACTIONID=? and transactionitem.TOYID = ? and transactionheader.CUSTID=? and transactionheader.DELIVERYPROGRSS='COMPLETED' and 0= (select COUNT(*) FROM message where message.TOYID=? and message.TRANSACTIONID=? and message.CUSTID=?)");
            pstmt.setInt(1, transID);
            pstmt.setInt(2, toyID);
            pstmt.setInt(3, custID);
            pstmt.setInt(4, toyID);
            pstmt.setInt(5, transID);
            pstmt.setInt(6, custID);
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                return true;
            }
            pstmt.close();
            conn.close();
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public ArrayList<Message> listMessageReply(int msgid) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MESSAGE,user where REPLYMSGID=? and MESSAGE.MANAGERID=user.USERID");
            System.out.print(pstmt);
            pstmt.setInt(1, msgid);
            ArrayList<Message> tempMessageList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Message tempMessage = new Message();
                tempMessage.setMessageID(rs.getInt("MESSAGEID"));
                tempMessage.setToyID(rs.getInt("TOYID"));
                tempMessage.setCustID(rs.getInt("CUSTID"));
                tempMessage.setContent(rs.getString("CONTENT"));
                tempMessage.setRating(rs.getInt("Rating"));
                tempMessage.setDate(rs.getString("DATE"));
                tempMessage.setCustName(rs.getString("USERNAME"));
                tempMessageList.add(tempMessage);
                return tempMessageList;
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempMessageList;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<Message> listMessage() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MESSAGE");
            ArrayList<Message> tempMessageList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Message tempMessage = new Message();
                tempMessage.setMessageID(rs.getInt("MESSAGEID"));
                tempMessage.setToyID(rs.getInt("TOYID"));
                tempMessage.setCustID(rs.getInt("CUSTID"));
                tempMessage.setContent(rs.getString("CONTENT"));
                tempMessageList.add(tempMessage);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempMessageList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Message> listMessageFromID(String TOYID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MESSAGE,user where TOYID = " + TOYID + " and MESSAGE.CUSTID=user.USERID and REPLYMSGID is null");
            ArrayList<Message> tempMessageList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("TOYID"));
                Message tempMessage = new Message();
                tempMessage.setMessageID(rs.getInt("MESSAGEID"));
                tempMessage.setToyID(rs.getInt("TOYID"));
                tempMessage.setCustID(rs.getInt("CUSTID"));
                tempMessage.setContent(rs.getString("CONTENT"));
                tempMessage.setRating(rs.getInt("Rating"));
                tempMessage.setDate(rs.getString("DATE"));
                tempMessage.setCustName(rs.getString("USERNAME"));
                tempMessageList.add(tempMessage);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempMessageList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean createMessage(int transID,int toyID, int custID, String content,int rating) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MESSAGE(TRANSACTIONID,TOYID,CUSTID,CONTENT,Rating) VALUES (?,?,?,?,?)");
            pstmt.setInt(1, transID);
            pstmt.setInt(2, toyID);
            pstmt.setInt(3, custID);
            pstmt.setString(4, content);
            pstmt.setInt(5, rating);
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(messageDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean deleteMessage(int messageID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM MESSAGE WHERE MESSAGEID = ?");
            pstmt.setInt(1, messageID);
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(messageDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
    
    public ArrayList<Message> listMessageHeader() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM COMMENTHEADER");
            ArrayList<Message> tempMessageList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Message tempMessage = new Message();
                tempMessage.setMessageID(rs.getInt("MESSAGEID"));
                tempMessage.setToyID(rs.getInt("TOYID"));
                tempMessage.setCustID(rs.getInt("CUSTID"));
                tempMessage.setContent(rs.getString("CONTENT"));
                tempMessage.setDate(rs.getString("DATE"));
                tempMessageList.add(tempMessage);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempMessageList;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<Message> listMessageFromName(String TOYNAME) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM COMMENTHEADER where TOYNAME LIKE '%?%'");
            ArrayList<Message> tempMessageList = new ArrayList();
            pstmt.setString(1, TOYNAME);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("TOYID"));
                Message tempMessage = new Message();
                tempMessage.setMessageID(rs.getInt("MESSAGEID"));
                tempMessage.setToyID(rs.getInt("TOYID"));
                tempMessage.setCustID(rs.getInt("CUSTID"));
                tempMessage.setContent(rs.getString("CONTENT"));
                tempMessage.setDate(rs.getString("DATE"));
                tempMessageList.add(tempMessage);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempMessageList;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean createReply(int toyID, int managerID, String content) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MESSAGE(TOYID,CUSTID,MANAGERID,CONTENT) VALUES (?,?,?,?)");
            
            pstmt.setInt(1, toyID);
            pstmt.setInt(2, managerID);
            pstmt.setInt(3, managerID);
            pstmt.setString(4, content);
           // pstmt.setInt(4, 0);
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
           // return true;
           return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(messageDB.class.getName()).log(Level.SEVERE, null, ex1);
                
            }
            return false;
        }
    }
}
