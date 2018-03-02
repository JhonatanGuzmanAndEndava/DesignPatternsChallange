package com.bank.agents.factory;

import com.bank.client.Client;

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
    public String attend(Client client) {
        String operationMessage = client.getOperation().performOperation();
        return this.getJobName()+" "+this.getAgentId()+" has attended "+client.toString() + ": "+operationMessage;
    }
}
