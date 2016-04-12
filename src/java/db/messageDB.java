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
public class messageDB extends GeneralDB{
     public messageDB() {
        connectDB();
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MESSAGE where TOYID = "+ TOYID);
            ArrayList<Message> tempMessageList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("TOYID"));
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
    
    public boolean createMessage(int toyID,int custID,String content) {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
             conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MESSAGE(TOYID,CUSTID,CONTENT) VALUES (?,?,?)");
            pstmt.setInt(1, toyID);
            pstmt.setInt(2, custID);
            pstmt.setString(3, content);
            
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
    
    public boolean deleteMessage(int messageID)
    {
        Connection conn =null;
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
}
