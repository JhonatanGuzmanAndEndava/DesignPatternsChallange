package com.bank.agents;

import Main.Client;

public interface Agent {

    String getJobName();

    int getAgentId();

    String attend(Client client);
}
