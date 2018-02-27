package com.observer;

import com.messages.Message;

import java.util.ArrayList;

public class Distributor implements Subject{

    private ArrayList<Observer> observers;
    private Message transactionMessage;

    public Distributor() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        observers.remove(index);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(transactionMessage);
        }
    }

    @Override
    public void setMessage(Message transactionMessage){
        this.transactionMessage = transactionMessage;
        notifyObservers();
    }
}
