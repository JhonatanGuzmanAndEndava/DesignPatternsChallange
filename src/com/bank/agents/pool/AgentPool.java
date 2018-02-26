package com.bank.agents.pool;

import com.bank.agents.factory.Agent;
import com.bank.agents.factory.AgentFactory;

/**
 * Pool of cashiers
 */
public class AgentPool extends ObjectPool<Agent> {
    public AgentPool(int numOfAgents, String type) {
        super(numOfAgents, type);
    }

    /**
     *Creates a cashier with ID = usedID+1
     * @param type tells the agent factory which kind of agent wants to be created
     * @return the created cashier
     */
    @Override
    protected Agent createObject(String type) {
        return AgentFactory.getInstance().getAgent(type);
    }

}
