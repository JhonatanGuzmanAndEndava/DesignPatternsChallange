package com.bank.agents;

public class AgentFactory {
    private static AgentFactory ourInstance = new AgentFactory();

    public static AgentFactory getInstance() {
        return ourInstance;
    }

    private AgentFactory() {
    }

    public Agent getAgent(String agentType){
        if(agentType != null || !agentType.isEmpty()){
            if(agentType.equalsIgnoreCase("Cashier"))
                return new Cashier();
            else if(agentType.equalsIgnoreCase("Supervisor"))
                return new Supervisor();
            else if(agentType.equalsIgnoreCase("Director"))
                return new Director();
        }
        return null;
    }
}
