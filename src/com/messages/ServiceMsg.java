package com.messages;

import com.observer.Subject;

public class ServiceMsg {

    public static Subject distributorMessage;

    public static void setDistributorMessage(Subject distributorMessageSubj){
        distributorMessage = distributorMessageSubj;
    }

    public static synchronized void sendMessagetransaction(Message transaction) {
        distributorMessage.setMessage(transaction);
    }
}