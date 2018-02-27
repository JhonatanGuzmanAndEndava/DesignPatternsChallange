package com.bank.agents.factory;

import com.bank.client.Client;

public interface Agent {

    String getJobName();

    int getAgentId();

    String attend(Client client);
}
