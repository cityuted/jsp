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
public class Delivery {
    private int deliveryID;
    private String deliveryProgress;
    private String deliveryTime;

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

    /**
     * @return the deliveryProgress
     */
    public String getDeliveryProgress() {
        return deliveryProgress;
    }

    /**
     * @param deliveryProgress the deliveryProgress to set
     */
    public void setDeliveryProgress(String deliveryProgress) {
        this.deliveryProgress = deliveryProgress;
    }

    /**
     * @return the deliveryTime
     */
    public String getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * @param deliveryTime the deliveryTime to set
     */
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
}
