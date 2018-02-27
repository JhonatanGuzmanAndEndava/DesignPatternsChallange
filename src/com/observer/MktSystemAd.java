package com.observer;

public class MktSystemAd extends MktServiceLegacy {
    @Override
    public void sendAD(String customerID, String email) {
        System.out.println("Sending cupons for customer "+customerID);
    }
}
