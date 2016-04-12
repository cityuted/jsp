/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mesong
 */
public class GeneralDB {

    protected static final String conn_username = "root";
    protected static final String conn_password = "";

    protected static final String conn_url = "jdbc:mysql://localhost/toymarket";
    protected static final String jdbc_driver = "com.mysql.jdbc.Driver";

    public GeneralDB() {

    }

    public void connectDB() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

        }
    }

    public boolean create(String tableName, String[] cols, String[] values) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url, conn_username, conn_password);
            conn.setAutoCommit(false);
            String attribute = "(" + getColLabel(cols) + ")";
            String parameter = "(" + getValueLabel(cols) + ")";
            String sql = "INSERT INTO " + tableName + attribute + " VALUES" + parameter;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 1; i <= cols.length; i++) {
                if (ableToConvertInt(cols[i - 1])) {
                    pstmt.setInt(i, Integer.parseInt(values[i - 1]));
                } else {
                    pstmt.setString(i, values[i - 1]);
                }
            }
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(GeneralDB.class.getName()).log(Level.SEVERE, null, ex1);
            }

            return false;
        }

    }

    public String getColLabel(String[] parameters) {
        String temp = "";
        for (int i = 0; i < parameters.length; i++) {

            temp += parameters[i];
            if (i != parameters.length - 1) {
                temp += ",";
            }
        }
        return temp;
    }

    public String getValueLabel(String[] parameters) {
        String temp = "";
        for (int i = 0; i < parameters.length; i++) {

            temp += "?";
            if (i != parameters.length - 1) {
                temp += ",";
            }
        }
        return temp;
    }

    public boolean ableToConvertInt(String v) {
        try {
            int temp = Integer.parseInt(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
