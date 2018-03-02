package com.bank.agents.factory;

import com.bank.client.Client;
import com.bank.messages.Message;
import com.bank.messages.TransactionMessage;

import java.util.concurrent.atomic.AtomicInteger;

public class Director implements Agent {
    private static final AtomicInteger directorIdCount = new AtomicInteger(0);
    private final int directorId;

    protected Director(){
        directorId = directorIdCount.incrementAndGet();
    }

    @Override
    public String getJobName() {
        return "Director";
    }

    @Override
    public int getAgentId() {
        return directorId;
    }

    @Override
    public Message attend(Client client) {
        return new TransactionMessage(client.getBankTurn(), client.getEmail(), this.getAgentId(), this.getJobName(),
                client.getAccountID(), client.getOperation().getOperationDate().toString(), client.getOperation().getOperationValue(),
                client.getOperation());
    }
}
