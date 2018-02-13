package com.endava;

import com.endava.legacy.CuponMktService;
import com.endava.legacy.MktService;

/**
 * Created by gleon on 2/13/2018.
 */
public class Bank {
    public static  void main (String args[]){
        MktService mkt = new CuponMktService();
        mkt.sendAD("79727443","interns@endava.com");

    }
}
