package com.bank.observable;

import com.bank.messages.Message;
import com.bank.observer.Observer;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void setMessage(Message message);
}
