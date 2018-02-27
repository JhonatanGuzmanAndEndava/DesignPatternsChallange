package com.observer;
import com.messages.Message;

public class AuditModule implements Observer{
    private Message transactionMessage;

    @Override
    public void update(Message transactionMessage) {
        this.transactionMessage = transactionMessage;
    }
}
