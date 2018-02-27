package com.bank.agents.factory;

import com.bank.client.Client;

import java.util.concurrent.atomic.AtomicInteger;

public class Director implements Agent {
    private static final AtomicInteger directorIdCount = new AtomicInteger(0);
    private final int directorId;

    public Director(){
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
    public String attend(Client client) {
        String operationMessage = client.getOperation().performOperation();
        return this.getJobName() + " " + this.getAgentId() + " has attended " + client.toString() + ": " + operationMessage;
    }
}
