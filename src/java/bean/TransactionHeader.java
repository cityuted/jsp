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
public class TransactionHeader {
    int TRANSACTIONID,CUSTID;
    String DELIVERYAddressee,DELIVERYAddresseePhone,DELIVERYOPTION,DELIVERYADDRESS,DELIVERYPROGRSS,DELIVERYTIME,Payment;
    public TransactionHeader(){
        
    }

    public int getTRANSACTIONID() {
        return TRANSACTIONID;
    }

    public void setTRANSACTIONID(int TRANSACTIONID) {
        this.TRANSACTIONID = TRANSACTIONID;
    }

    public int getCUSTID() {
        return CUSTID;
    }

    public void setCUSTID(int CUSTID) {
        this.CUSTID = CUSTID;
    }

    public String getDELIVERYAddressee() {
        return DELIVERYAddressee;
    }

    public void setDELIVERYAddressee(String DELIVERYAddressee) {
        this.DELIVERYAddressee = DELIVERYAddressee;
    }

    public String getDELIVERYAddresseePhone() {
        return DELIVERYAddresseePhone;
    }

    public void setDELIVERYAddresseePhone(String DELIVERYAddresseePhone) {
        this.DELIVERYAddresseePhone = DELIVERYAddresseePhone;
    }

    public String getDELIVERYOPTION() {
        return DELIVERYOPTION;
    }

    public void setDELIVERYOPTION(String DELIVERYOPTION) {
        this.DELIVERYOPTION = DELIVERYOPTION;
    }

    public String getDELIVERYADDRESS() {
        return DELIVERYADDRESS;
    }

    public void setDELIVERYADDRESS(String DELIVERYADDRESS) {
        this.DELIVERYADDRESS = DELIVERYADDRESS;
    }

    public String getDELIVERYPROGRSS() {
        return DELIVERYPROGRSS;
    }

    public void setDELIVERYPROGRSS(String DELIVERYPROGRSS) {
        this.DELIVERYPROGRSS = DELIVERYPROGRSS;
    }

    public String getDELIVERYTIME() {
        return DELIVERYTIME;
    }

    public void setDELIVERYTIME(String DELIVERYTIME) {
        this.DELIVERYTIME = DELIVERYTIME;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String Payment) {
        this.Payment = Payment;
    }
}
