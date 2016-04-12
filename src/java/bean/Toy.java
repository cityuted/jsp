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
public class Toy {
    private int toyID;
    private String toyName;
    private String description;
    private String toyIcon;
    private int cashpoint;
    private int QTY;
    private int discount;
    private int typeID;
    private int secondHandID;

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
     * @return the toyName
     */
    public String getToyName() {
        return toyName;
    }

    /**
     * @param toyName the toyName to set
     */
    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the cashpoint
     */
    public int getCashpoint() {
        return cashpoint;
    }

    /**
     * @param cashpoint the cashpoint to set
     */
    public void setCashpoint(int cashpoint) {
        this.cashpoint = cashpoint;
    }

    /**
     * @return the QTY
     */
    public int getQTY() {
        if(QTY==0){
            return 1;
        }
        return QTY;
    }

    /**
     * @param QTY the QTY to set
     */
    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    /**
     * @return the typeID
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * @param typeID the typeID to set
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    /**
     * @return the toyIcon
     */
    public String getToyIcon() {
        return toyIcon;
    }

    /**
     * @param toyIcon the toyIcon to set
     */
    public void setToyIcon(String toyIcon) {
        this.toyIcon = toyIcon;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the disucount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @return the secondHandID
     */
    public int getSecondHandID() {
        return secondHandID;
    }

    /**
     * @param secondHandID the secondHandID to set
     */
    public void setSecondHandID(int secondHandID) {
        this.secondHandID = secondHandID;
    }
}
