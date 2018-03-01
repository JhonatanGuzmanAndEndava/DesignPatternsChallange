package com.bank.messages;

import com.bank.subject.Subject;

public class ServiceMsg {

    public static Subject distributorMessage;

    public static void setDistributorMessage(Subject distributorMessageSubj){
        distributorMessage = distributorMessageSubj;
    }

    public static synchronized void sendMessageTransaction(Message transaction) {
        distributorMessage.setMessage(transaction);
    }
}
