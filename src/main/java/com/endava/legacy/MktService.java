package com.endava.legacy;

/**
 * Created by gleon on 2/13/2018.
 */
abstract public class MktService {
    public void updateInformation(String customerID, Double transactionValue, String email) {
        System.out.println("Check value :" + transactionValue);
        this.sendAD(customerID, email);
    }

    abstract public void sendAD(String CustomerID, String email);
}
