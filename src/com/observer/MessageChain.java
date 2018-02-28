package com.observer;

import com.messages.Message;

import java.util.Arrays;
import java.util.List;

public abstract class MessageChain {

    protected Message transactionMessage;
    protected MessageChain nextInChain;

    public void setNextInChain(MessageChain messageChain) {
        this.nextInChain = messageChain;
    }

    public void deliverMessage(Message transactionMessage){
        List<String> messageInformation = Arrays.asList(transactionMessage.getInformation().split(","));
        double transactionValue = Double.parseDouble(messageInformation.get(6));
        if(transactionValue >= 10000){
            writeMessage(transactionMessage);
        }
        if(nextInChain !=null){
            nextInChain.deliverMessage(transactionMessage);
        }
    }

    public abstract void writeMessage(Message transactionMessage);


}
