package com.bank.agents.factory;

import com.bank.client.Client;
import com.bank.messages.Message;
import com.bank.messages.TransactionMessage;

import java.util.concurrent.atomic.AtomicInteger;

public class Supervisor implements Agent {
    private static final AtomicInteger supervisorIdCount = new AtomicInteger(0);
    private final int supervisorId;

    protected Supervisor(){
        supervisorId = supervisorIdCount.incrementAndGet();
    }

    @Override
    public String getJobName() {
        return "Supervisor";
    }

    @Override
    public int getAgentId() {
        return supervisorId;
    }

    @Override
    public Message attend(Client client) {
        return new TransactionMessage(client.getBankTurn(), client.getEmail(), this.getAgentId(), this.getJobName(),
                client.getAccountID(), client.getOperation().getOperationDate().toString(), client.getOperation().getOperationValue(),
                client.getOperation());
    }
}
