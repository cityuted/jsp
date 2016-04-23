/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.ocpsoft.prettytime.PrettyTime;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mesong
 */
public class Message {

    private int messageID;
    private int toyID;
    private int custID;
    private String custName;
    private String content;
    private String date;
    private int rating;
    private int managerID = -1;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the messageID
     */
    public int getMessageID() {
        return messageID;
    }

    /**
     * @param messageID the messageID to set
     */
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    /**
     * @return the toyID
     */
    public int getToyID() {
        return toyID;
    }

    /**
     * @param toyID the toyID to set
     */
    public void setToyID(int toyID) {
        this.toyID = toyID;
    }

    /**
     * @return the custID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getRelativeTime() {
        String temp =date;
        PrettyTime p = new PrettyTime(new Locale("en"));
        try {
            
            
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            Date date;
            date = sdf.parse(temp);
            temp =p.format(date);
            //System.out.println(date);
            //System.out.println(p.format(date));
        } catch (ParseException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            return temp;
        }
        return temp;
    }

    /**
     * @return the managerID
     */
    public int getManagerID() {
        return managerID;
    }

    /**
     * @param managerID the managerID to set
     */
    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

}
