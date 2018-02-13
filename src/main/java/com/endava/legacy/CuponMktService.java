package com.endava.legacy;

/**
 * Created by gleon on 2/13/2018.
 */
public class CuponMktService extends MktService {
    public void sendAD(String CustomerID, String email) {
        System.out.print("Sending Coupons to "+ CustomerID +" with email " +email);
    }
}
