package com.bank.agents.factory;

import com.bank.client.Client;
import com.bank.messages.Message;
import com.bank.messages.TransactionMessage;

import java.util.concurrent.atomic.AtomicInteger;

public class Cashier implements Agent {
    private static final AtomicInteger cashierIdCount = new AtomicInteger(0);
    private final int cashierId;

    protected Cashier(){
        cashierId = cashierIdCount.incrementAndGet();
    }

    @Override
    public String getJobName() {
        return "Cashier";
    }

    @Override
    public int getAgentId() {
        return cashierId;
    }

    @Override
    public Message attend(Client client) {
        return new TransactionMessage(client.getBankTurn(), client.getEmail(), this.getAgentId(), this.getJobName(),
                client.getAccountID(), client.getOperation().getOperationDate().toString(), client.getOperation().getOperationValue(),
                client.getOperation());
    }
}
