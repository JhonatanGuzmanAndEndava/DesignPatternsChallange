package com.bank.agents.factory;

import Main.Client;

public interface Agent {

    String getJobName();

    int getAgentId();

    String attend(Client client);
}
