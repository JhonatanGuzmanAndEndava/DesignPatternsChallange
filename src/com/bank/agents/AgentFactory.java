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
            if(agentType.equalsIgnoreCase("CASHIER"))
                return new Cashier();
            else if(agentType.equalsIgnoreCase("SUPERVISOR"))
                return new Supervisor();
            else if(agentType.equalsIgnoreCase("DIRECTOR"))
                return new Director();
        }
        return null;
    }
}
