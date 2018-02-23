package com.bank.agents;

import Main.Client;

/**
 * Lets associate the classes: Cashier, Supervisor and Director
 * Agents (Cashier,Supervisor and Director) have the same methods
 */
public interface BusyAgent {

    public void setTime(long time);

    public long getTime();

    public int getId();

    public TypeOfAgent getType();

    public Client getClientBeingAttended();

    public void setClientBeingAttended(Client clientBeingAttended);

}
