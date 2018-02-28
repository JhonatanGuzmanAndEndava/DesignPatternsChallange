package com.observer;
import com.messages.Message;

import java.util.Arrays;
import java.util.List;

public class AuditModule extends MessageChain implements Observer{

    @Override
    public void update(Message transactionMessage) {
        this.transactionMessage = transactionMessage;
        deliverMessage(this.transactionMessage);
    }

    @Override
    public void writeMessage(Message transactionMessage) {
        List<String> messageInformation = Arrays.asList(transactionMessage.getInformation().split(","));
        String transactionType = messageInformation.get(7);
        if(transactionType.equalsIgnoreCase("Deposit"))
            Logger.writeLog(transactionMessage);
    }
}
