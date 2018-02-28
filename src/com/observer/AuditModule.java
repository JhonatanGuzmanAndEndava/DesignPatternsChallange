package com.observer;
import com.messages.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuditModule implements Observer{

    private Message transactionMessage;

    @Override
    public void update(Message transactionMessage) {
        this.transactionMessage = transactionMessage;
        logMessage();
    }

    private void logMessage() {
        List<String> messageInformation = new ArrayList<String>();
        messageInformation = Arrays.asList(transactionMessage.getInformation().split(","));
        double transactionValue = Double.parseDouble(messageInformation.get(6));
        String transactionType = messageInformation.get(7);
        if(transactionValue >= 10000 && transactionType.equalsIgnoreCase("Deposit"))
            Logger.writeLog(this.transactionMessage);
    }
}
