package com.bank.observer;

import com.bank.messages.Message;

public interface Observer {

    public void update(Message message);

}
