package com.bank.dispatcher;

import Main.Client;
import com.bank.agents.factory.Agent;

import java.util.function.Supplier;

/**
 * Class responsible for attending a given client with a given agent
 * When the threadPool attends the supply, this class indicates the action to be performed with the thread
 */
public class SupplierOfAgents implements Supplier<Agent> {

    Agent busyAgent;
    Client client;

    /**
     * Constructor method
     * @param busyAgent is the Agent which is going to attend the client
     */
    public SupplierOfAgents(Agent busyAgent, Client clientToAttend) {
        client = clientToAttend;
        this.busyAgent = busyAgent;
    }

    @Override
    /**
     * Displays a message to tell the user which agent is attending which client
     * Calculates the attention time
     * Causes the current thread to suspend execution for that attention time
     * Assigns to the Agent the attention time
     */
    public Agent get() {
        try {
            System.out.println(busyAgent.attend(client));
            long tiempo = ((int) Math.floor(Math.random() * (6) + 10)) * 1000;
            Thread.sleep(tiempo);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            return busyAgent;
        }
    }

}
