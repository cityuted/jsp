/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.CheckoutStatus;
import bean.Toy;
import bean.TransactionHeader;
import com.mysql.jdbc.Statement;
import static db.GeneralDB.conn_url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mesong
 */
public class TransactionDB extends GeneralDB {

    public TransactionDB() {
        connectDB();
    }

    public boolean createTransaction(int custID, CheckoutStatus checkoutStatus, bean.Cart cart) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO transactionheader(CUSTID,DELIVERYAddressee,DELIVERYAddresseePhone,DELIVERYOPTION,DELIVERYADDRESS,DELIVERYTIME,Payment) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, custID);
            pstmt.setString(2, checkoutStatus.getAddressee());
            pstmt.setString(3, checkoutStatus.getTel());
            pstmt.setString(4, checkoutStatus.getDelivery());
            pstmt.setString(5, checkoutStatus.getAddress());
            Date dNow = new Date();
            SimpleDateFormat ft
                    = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
            pstmt.setString(6, ft.format(dNow));
            pstmt.setString(7, checkoutStatus.getPayment());
            pstmt.executeUpdate();
            conn.commit();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            createTransactionItem(rs.getInt(1), cart);
            pstmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TransactionDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean createTransactionItem(int TRANSACTIONID, bean.Cart cart) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            for (int i = 0; i < cart.getSize(); i++) {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO transactionitem(TRANSACTIONID,TOYID,QTY) VALUES (?,?,?)");
                pstmt.setInt(1, TRANSACTIONID);
                pstmt.setInt(2, cart.getToys().get(i).getToyID());
                pstmt.setInt(3, cart.getToys().get(i).getQTY());
                pstmt.executeUpdate();
                conn.commit();
                pstmt.close();
                conn.close();
            }
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TransactionDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<TransactionHeader> listTransactionHeader(int custID) {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM transactionheader where CUSTID = ? ");
            pstmt.setInt(1, custID);
            ArrayList<TransactionHeader> tempList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                TransactionHeader tempToy = new TransactionHeader();
                tempToy.setTRANSACTIONID(rs.getInt("TRANSACTIONID"));
                tempToy.setCUSTID(rs.getInt("CUSTID"));
                tempToy.setDELIVERYAddressee(rs.getString("DELIVERYAddressee"));
                tempToy.setDELIVERYAddresseePhone(rs.getString("DELIVERYAddresseePhone"));
                tempToy.setDELIVERYOPTION(rs.getString("DELIVERYOPTION"));
                tempToy.setDELIVERYADDRESS(rs.getString("DELIVERYADDRESS"));
                tempToy.setDELIVERYPROGRSS(rs.getString("DELIVERYPROGRSS"));
                tempToy.setDELIVERYTIME(rs.getString("DELIVERYTIME"));
                tempToy.setPayment(rs.getString("Payment"));
                tempList.add(tempToy);
            }
            //stmnt.executeQuery()
            pstmt.close();
            conn.close();
            return tempList;
        } catch (SQLException ex) {
            return null;
        }
    }

}
