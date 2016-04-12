/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Mesong
 */
public class Transaction {
    private int transactionID;
    private int custID;
    private String deliveryOption;
    private int deliveryID;

    /**
     * @return the transactionID
     */
    public int getTransactionID() {
        return transactionID;
    }

    /**
     * @param transactionID the transactionID to set
     */
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
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
     * @return the deliveryOption
     */
    public String getDeliveryOption() {
        return deliveryOption;
    }

    /**
     * @param deliveryOption the deliveryOption to set
     */
    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    /**
     * @return the deliveryID
     */
    public int getDeliveryID() {
        return deliveryID;
    }

    /**
     * @param deliveryID the deliveryID to set
     */
    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }
    
}
