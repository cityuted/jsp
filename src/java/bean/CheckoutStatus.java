/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ted
 */
public class CheckoutStatus {
    Boolean boolAddressee=false,boolAddress=false,boolDelivery=false,boolPayment=false;
    String addressee,tel,address,delivery,payment,creditCardID,firstName,lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(String creditCardID) {
        this.creditCardID = creditCardID;
    }
    public CheckoutStatus(){
        
    }

    public Boolean getBoolAddressee() {
        return boolAddressee;
    }

    public void setBoolAddressee(Boolean boolAddressee) {
        this.boolAddressee = boolAddressee;
    }

    public Boolean getBoolAddress() {
        return boolAddress;
    }

    public void setBoolAddress(Boolean boolAddress) {
        this.boolAddress = boolAddress;
    }

    public Boolean getBoolDelivery() {
        return boolDelivery;
    }

    public void setBoolDelivery(Boolean boolDelivery) {
        this.boolDelivery = boolDelivery;
    }

    public Boolean getBoolPayment() {
        return boolPayment;
    }

    public void setBoolPayment(Boolean boolPayment) {
        this.boolPayment = boolPayment;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
}
