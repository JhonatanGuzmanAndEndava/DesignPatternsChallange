package com.observer;

import com.messages.Message;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void setMessage(Message message);
}
