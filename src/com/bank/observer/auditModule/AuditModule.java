package com.bank.observer.auditModule;
import com.bank.messages.Message;
import com.bank.messages.TransactionMessage;
import com.bank.observer.Observer;

public class AuditModule extends MessageChain implements Observer {

    @Override
    public void update(Message transactionMessage) {
        this.transactionMessage = transactionMessage;
        deliverMessage(this.transactionMessage);
    }

    @Override
    public void writeMessage(Message transactionMessage) {
        TransactionMessage transactionMsg = (TransactionMessage)transactionMessage;
        String transactionType = transactionMsg.getTransactionType().getOperationType();
        if(transactionType.equalsIgnoreCase("Deposit"))
            Logger.writeLog(transactionMessage);
    }
}
