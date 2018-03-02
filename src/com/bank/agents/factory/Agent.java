package com.bank.agents.factory;

import com.bank.client.Client;
import com.bank.messages.Message;

public interface Agent {

    String getJobName();

    int getAgentId();

    Message attend(Client client);
}
