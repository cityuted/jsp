/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
public class userDB extends GeneralDB {

    public userDB() {
        connectDB();
    }

    public ArrayList<User> listUser() {
        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER");
            ArrayList<User> tempUserList = new ArrayList();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                User tempUser = new User();
                tempUser.setUserID(rs.getInt("UserID"));
                tempUser.setUserName(rs.getString("UserName"));
                tempUser.setUserSex(rs.getString("UserSex"));
                tempUser.setLoginName(rs.getString("LoginName"));
                tempUser.setPassword(rs.getString("Password"));
                tempUser.setUserAddress(rs.getString("UserAddress"));
                tempUser.setUserPhone(rs.getString("UserPhone"));
                tempUser.setEmail(rs.getString("Email"));
                tempUser.setCashpoint(rs.getInt("Cashpoint"));
                tempUser.setTypeID(rs.getInt("TypeID"));
                tempUserList.add(tempUser);
            }
            //stmnt.executeQuery()
            return tempUserList;
        } catch (SQLException ex) {
            return null;
        }
    }

    public User searchUser(String loginName, String password) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE LOGINNAME = ? AND PASSWORD = ?");
            pstmt.setString(1, loginName);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            //while(rs.next() && rs!=null)
            rs.next();
            //{
            User tempUser = new User();
            tempUser.setUserID(rs.getInt("UserID"));
            tempUser.setUserName(rs.getString("UserName"));
            tempUser.setUserSex(rs.getString("UserSex"));
            tempUser.setLoginName(rs.getString("LoginName"));
            tempUser.setPassword(rs.getString("Password"));
            tempUser.setUserAddress(rs.getString("UserAddress"));
            tempUser.setUserPhone(rs.getString("UserPhone"));
            tempUser.setEmail(rs.getString("Email"));
            tempUser.setCashpoint(rs.getInt("Cashpoint"));
            tempUser.setTypeID(rs.getInt("TypeID"));
            //return "1";
            return tempUser;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }

    }

    public boolean createUser(String userName, String userSex, String loginName, String password, String userAddress, String userPhone, String email) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USER(USERNAME,USERSEX,LOGINNAME,PASSWORD,USERADDRESS,USERPHONE,EMAIL)"
                    + "VALUES(?,?,?,?,?,?,?)");
            pstmt.setString(1, userName);
            pstmt.setString(2, userSex);
            pstmt.setString(3, loginName);
            pstmt.setString(4, password);
            pstmt.setString(5, userAddress);
            pstmt.setString(6, userPhone);
            pstmt.setString(7, email);

            pstmt.executeUpdate();
            // }
            //stmnt.executeQuery()
            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public boolean updateUser(String userID, String password, String userAddress, String userPhone, String email) {
        if (!password.equals("")) {
            password = "PASSWORD='" + password + "',";
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE USER SET " + password + "USERADDRESS=?,USERPHONE=?,EMAIL=?"
                    + "WHERE USERID = ?");

            pstmt.setString(1, userAddress);
            pstmt.setString(2, userPhone);
            pstmt.setString(3, email);
            pstmt.setString(4, userID);
            pstmt.executeUpdate();
            // }
            //stmnt.executeQuery()
            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public boolean upgradeUser(String userID, int typeID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE USER SET TYPEID=? WHERE USERID = ?");

            pstmt.setInt(1, typeID);
            pstmt.setString(2, userID);
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
                Logger.getLogger(userDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean deduceCashpoint(String userID, int cashpoint) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE USERID ='" + userID + "';");
            if (rs == null && rs.next() != true) {
                throw new SQLException("No result found.");
            }
            rs.next();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE USER SET CASHPOINT=? WHERE USERID = ?");

            int balance = rs.getInt("CASHPOINT") - cashpoint;
            if (balance < 0) {
                throw new SQLException("Not enough cashpoint");
            }
            pstmt.setInt(1, balance);
            pstmt.setString(2, userID);
            pstmt.executeUpdate();
            // }
            //stmnt.executeQuery()
            conn.commit();
            pstmt.close();
            stmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean deleteUser(String userID) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM USER WHERE USERID = ?");

            pstmt.setString(1, userID);
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
                Logger.getLogger(userDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }

    public User searchUserByID(int userID) {

        try {
            Connection conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE USERID = ?");
            pstmt.setInt(1, userID);

            ResultSet rs = pstmt.executeQuery();
            //while(rs.next() && rs!=null)
            rs.next();
            //{
            User tempUser = new User();
            tempUser.setUserID(rs.getInt("UserID"));
            tempUser.setUserName(rs.getString("UserName"));
            tempUser.setUserSex(rs.getString("UserSex"));
            tempUser.setLoginName(rs.getString("LoginName"));
            tempUser.setPassword(rs.getString("Password"));
            tempUser.setUserAddress(rs.getString("UserAddress"));
            tempUser.setUserPhone(rs.getString("UserPhone"));
            tempUser.setEmail(rs.getString("Email"));
            tempUser.setCashpoint(rs.getInt("Cashpoint"));
            tempUser.setTypeID(rs.getInt("TypeID"));
            //return "1";
            return tempUser;
            // }
            //stmnt.executeQuery()

        } catch (SQLException ex) {
            return null;
        }

    }

    public boolean updateCashoint(int custID, int cashpoint) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE  USER SET CASHPOINT = ? WHERE USERID = ?");
            pstmt.setInt(1, cashpoint);
            pstmt.setInt(2, custID);
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
                Logger.getLogger(userDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
