package com.bank.observer.marketingSystem;

abstract class MktServiceLegacy {

    public void updateInformation(String customerID, Double transactionValue, String email){
        System.out.println("Check value :" + transactionValue);
        this.sendAD(customerID,email);
    }

    abstract public void sendAD(String customerID, String email);
}
