package com.bank.agents;

import Main.Client;

import java.util.concurrent.atomic.AtomicInteger;

public class Cashier implements Agent {
    private static final AtomicInteger cashierIdCount = new AtomicInteger(0);
    private final int cashierId;

    public Cashier(){
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
    public String attend(Client client) {
        return this.getJobName()+" "+this.getAgentId()+" has attended "+client.toString();
    }
}
